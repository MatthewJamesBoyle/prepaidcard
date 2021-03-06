package boylem.matt.transaction.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boylem.matt.transaction.client.AccountClient;
import boylem.matt.transaction.client.MerchantClient;
import boylem.matt.transaction.dao.transactionDao;
import boylem.matt.transaction.domain.Card;
import boylem.matt.transaction.domain.Merchant;
import boylem.matt.transaction.domain.Refund;
import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.domain.TransactionStatus;
import boylem.matt.transaction.domain.TransactionType;
import boylem.matt.transaction.exception.CardNotFoundException;
import boylem.matt.transaction.exception.LackOfOwnershipException;
import boylem.matt.transaction.exception.NotCapturableAmountException;
import boylem.matt.transaction.exception.NotEnoughMoneyException;
import boylem.matt.transaction.exception.TransactionNotFoundException;
import boylem.matt.transaction.exception.TransactionServiceException;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountClient accountClient;

	@Autowired
	MerchantClient merchantClient;

	@Autowired
	transactionDao transactionDao;

	/**
	 * Create a transaction
	 * 
	 * @param transaction
	 * @return Transaction
	 * @throws TransactionServiceException
	 */
	public Transaction create(Transaction transaction) throws TransactionServiceException {
		if (transaction == null) {
			throw new TransactionServiceException("failed to create transaction");
		}

		Card card = accountClient.findCardById(transaction.getCardId());

		if (card == null) {
			throw new CardNotFoundException(transaction.getCardId());
		}

		if (card.getAccount().getAvailableBalance() < transaction.getTransactionAmount()) {
			throw new NotEnoughMoneyException(transaction.getTransactionAmount());
		}
		//
		// Update available balance on card to be available balance - amount;
		Card response = accountClient.authorizePayment(card.getId(), transaction.getTransactionAmount());
		if (response == null) {
			throw new TransactionServiceException("failed to create transaction");

		}
		// create a transaction with status blocked
		transaction.setCapturedAmount(0L);
		transaction.setTimeStamp(new Date());
		transaction.setStatus(TransactionStatus.BLOCKED);
		transactionDao.save(transaction);

		// if either of the above fails, roll back the entire transaction.
		return transaction;

	}

	/**
	 * Get all transactions in the CLEARED state.
	 * 
	 * @param accountId
	 * @return List<Transaction>
	 * @throws CardNotFoundException
	 */
	public List<Transaction> getAllTransactions(Long cardId) throws CardNotFoundException {
		List<Transaction> transactions = transactionDao.findByCardIdAndStatus(cardId, TransactionStatus.CLEARED);
		if (transactions == null) {
			throw new CardNotFoundException(cardId);
		}
		return transactions;
	}

	/**
	 * Capture a transaction
	 * 
	 * @param merchantId
	 * @param transactionId
	 * 
	 * @return Transaction
	 * 
	 * @throws TransactionNotFoundException
	 * @throws LackOfOwnershipException
	 * @throws TransactionServiceException
	 */
	public Transaction captureTransaction(Long merchantId, Long transactionId)
			throws LackOfOwnershipException, TransactionServiceException {
		Transaction toCapture = transactionDao.findById(transactionId);
		if (toCapture == null) {
			throw new TransactionNotFoundException(transactionId);
		}
		if (toCapture.getMerchantId() != merchantId) {
			throw new LackOfOwnershipException(merchantId, transactionId);
		}

		if (toCapture.getStatus() == TransactionStatus.CLEARED) {
			throw new TransactionServiceException("You can't capture a cleared transaction");
		}

		if (toCapture.getStatus() != TransactionStatus.BLOCKED) {
			throw new TransactionServiceException("You can't capture a transaction that is not in the BLOCKED state");
		}

		// Some service call here to send money to our merchants account... maybe they
		// have a prepaid card too?!
		toCapture.setStatus(TransactionStatus.CLEARED);

		// Clear the trnasaction in full;
		accountClient.finalizeTransaction(toCapture.getCardId(),
				toCapture.getTransactionAmount() - toCapture.getCapturedAmount());
		// Set captured amount to total transaction cost;
		toCapture.setCapturedAmount(toCapture.getTransactionAmount());
		transactionDao.save(toCapture);
		return toCapture;
	}

	/**
	 * Partially capture a transaction
	 * 
	 * @param merchantId
	 * @param transactionId
	 * @param amountToCapture
	 * 
	 * @return Transaction
	 * 
	 * @throws TransactionNotFoundException
	 * @throws LackOfOwnershipException
	 * @throws NotCapturableAmountException
	 * @throws TransactionServiceException
	 */
	public Transaction capturePartialTransaction(Long merchantId, Long transactionId, Long amountToCapture)
			throws LackOfOwnershipException, TransactionServiceException {
		Transaction toCapture = transactionDao.findById(transactionId);
		if (toCapture == null) {
			throw new TransactionNotFoundException(transactionId);
		}
		if (toCapture.getMerchantId() != merchantId) {
			throw new LackOfOwnershipException(merchantId, transactionId);
		}

		if (toCapture.getStatus() != TransactionStatus.BLOCKED) {
			throw new TransactionServiceException("You can't capture a transaction that is not in the BLOCKED state");

		}

		if (((toCapture.getTransactionAmount() - toCapture.getCapturedAmount()) - amountToCapture) < 0) {
			throw new NotCapturableAmountException(transactionId,
					toCapture.getTransactionAmount() - toCapture.getCapturedAmount(), amountToCapture);
		}
		if ((toCapture.getTransactionAmount() - toCapture.getCapturedAmount()) - amountToCapture == 0) {
			this.captureTransaction(merchantId, transactionId);
		}

		// if it doesn't clear the transaction, we don't finalize it. Its already
		// removed from the users available balance and in reality we don't partially
		// charge people's cards.
		toCapture.setCapturedAmount(toCapture.getCapturedAmount() + amountToCapture);
		transactionDao.save(toCapture);

		return toCapture;
	}

	/**
	 * Reverse a capture.
	 * 
	 * @param merchant
	 * @param transactionId
	 * @param amount
	 * @return
	 * @throws TransactionNotFoundException
	 * @throws NotCapturableAmountException
	 * @throws LackOfOwnershipException
	 * @throws TransactionServiceException
	 */
	public Transaction reverseCapture(Merchant merchant, Long transactionId, Long amount)
			throws LackOfOwnershipException, TransactionServiceException {
		Transaction toReverse = transactionDao.findById(transactionId);
		if (toReverse == null) {
			throw new TransactionNotFoundException(transactionId);
		}

		if (toReverse.getMerchantId() != merchant.getId()) {
			throw new LackOfOwnershipException(merchant.getId(), transactionId);
		}

		if (toReverse.getStatus() != TransactionStatus.CLEARED) {
			throw new TransactionServiceException(
					"You can't reverse the capture on a transaction that has been cleared. You should issue a refund instead");

		}

		if (toReverse.getCapturedAmount() + amount > toReverse.getTransactionAmount()) {
			throw new NotCapturableAmountException(transactionId,
					toReverse.getTransactionAmount() - toReverse.getCapturedAmount(), amount);
		}

		toReverse.setCapturedAmount(toReverse.getCapturedAmount() - amount);
		transactionDao.save(toReverse);
		return toReverse;
	}

	/**
	 * Refund a transaction
	 * 
	 * @param refund
	 * 
	 * @return Transaction
	 * 
	 * @throws TransactionNotFoundException
	 * @throws NotCapturableAmountException
	 * @throws LackOfOwnershipException
	 * @throws TransactionServiceException
	 */
	public Transaction refund(Refund refund) throws LackOfOwnershipException, TransactionServiceException {
		Transaction toRefund = transactionDao.findById(refund.getTransactionId());

		if (toRefund == null) {
			throw new TransactionNotFoundException(refund.getTransactionId());
		}

		if (toRefund.getMerchantId() != refund.getMerchantId()) {
			throw new LackOfOwnershipException(refund.getMerchantId(), refund.getTransactionId());
		}

		if (toRefund.getStatus() != TransactionStatus.CLEARED) {
			throw new TransactionServiceException("You can't refund a transaction that hasn't cleared");
		}

		if (refund.getAmount() > toRefund.getTransactionAmount()) {
			throw new TransactionServiceException("You can't refund more than the cost");
		}

		accountClient.refund(toRefund.getCardId(), refund.getAmount());
		toRefund.setStatus(TransactionStatus.REFUNDED);
		transactionDao.save(toRefund);
		Transaction refundedT = new Transaction(toRefund.getCardId(), toRefund.getMerchantId(), refund.getAmount(),
				TransactionType.REFUND, TransactionStatus.CLEARED, new Date());
		transactionDao.save(refundedT);

		return refundedT;

	}

}
