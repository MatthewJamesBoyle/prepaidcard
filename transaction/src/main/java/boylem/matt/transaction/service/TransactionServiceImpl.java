package boylem.matt.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boylem.matt.transaction.client.AccountClient;
import boylem.matt.transaction.client.MerchantClient;
import boylem.matt.transaction.dao.transactionDao;
import boylem.matt.transaction.domain.Card;
import boylem.matt.transaction.domain.Merchant;
import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.domain.TransactionStatus;
import boylem.matt.transaction.exception.CardNotFoundException;
import boylem.matt.transaction.exception.LackOfOwnershipException;
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

	public Transaction create(Transaction transaction) throws TransactionServiceException {
		if (transaction == null) {
			throw new TransactionServiceException("failed to create transaction");
		}
		Card card = accountClient.findCardById(transaction.getCardId());
		if (card == null) {
			throw new CardNotFoundException(transaction.getCardId());
		}

		if (card.getAccount().getAvailableBalance() < transaction.getAmount()) {
			throw new NotEnoughMoneyException(transaction.getAmount());
		}

		// Update available balance on card to be available balance - amount;
		Card response = accountClient.authorizePayment(card.getId());
		if (response == null) {
			throw new TransactionServiceException("failed to create transaction");

		}
		// create a transaction with status blocked
		transaction.setStatus(TransactionStatus.BLOCKED);
		transactionDao.save(transaction);

		// if either of the above fails, roll back the entire transaction.
		return transaction;

	}

	@Override
	public List<Transaction> getAllTransactions(Long cardId) throws CardNotFoundException {
		List<Transaction> transactions = transactionDao.findByCardId(cardId);
		if (transactions == null) {
			throw new CardNotFoundException(cardId);
		}
		return transactions;
	}

	@Override
	public Transaction captureTransaction(Merchant merchant, Long transactionId)
			throws TransactionNotFoundException, LackOfOwnershipException {
		Transaction toCapture = transactionDao.findById(transactionId);
		if (toCapture == null) {
			throw new TransactionNotFoundException(transactionId);
		}
		if (toCapture.getMerchantId() != merchant.getId()) {
			throw new LackOfOwnershipException(merchant.getId(), transactionId);
		}
		// Some service call here to send money to our merchants account... maybe they
		// have a prepaid card too?!
		toCapture.setStatus(TransactionStatus.CLEARED);
		accountClient.finalizeTransaction(toCapture.getCardId(), toCapture.getAmount());
		return toCapture;
	}

}
