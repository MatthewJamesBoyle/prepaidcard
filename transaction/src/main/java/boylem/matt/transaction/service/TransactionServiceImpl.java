package boylem.matt.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boylem.matt.transaction.domain.Card;
import boylem.matt.transaction.domain.Transaction;
import client.CardClient;
import utils.ErrorType;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	CardClient cardClient;

	public ResponseEntity<?> create(Transaction transaction) {
		if (transaction == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("please ensure you are passing the correct params"),
					HttpStatus.BAD_REQUEST);
		}
		Card card = cardClient.findCardById(transaction.getCardId());
		if (card == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("Not a valid card id"), HttpStatus.BAD_REQUEST);
		}

		if (card.getAccount().getAvailableBalance() < transaction.getAmount()) {
			return new ResponseEntity<ErrorType>(new ErrorType("Not enough money in account"), HttpStatus.BAD_REQUEST);
		}

		// Update available balance on card to be available balance - amount;
		// create a transaction with status blocked
		// if either of the above fails, roll back the entire transaction.

	}

}
