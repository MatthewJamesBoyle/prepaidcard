package boylem.matt.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boylem.matt.transaction.client.AccountClient;
import boylem.matt.transaction.dao.transactionDao;
import boylem.matt.transaction.domain.Card;
import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.domain.TransactionStatus;
import boylem.matt.transaction.exception.CardNotFoundException;
import boylem.matt.transaction.exception.NotEnoughMoneyException;
import boylem.matt.transaction.exception.TransactionServiceException;
import utils.ErrorType;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountClient accountClient;

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

}
