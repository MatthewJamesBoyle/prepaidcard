package boylem.matt.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.transaction.domain.Merchant;
import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.exception.CardNotFoundException;
import boylem.matt.transaction.exception.LackOfOwnershipException;
import boylem.matt.transaction.exception.MerchantException;
import boylem.matt.transaction.exception.TransactionNotFoundException;
import boylem.matt.transaction.exception.TransactionServiceException;
import boylem.matt.transaction.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Transaction createTransaction(Transaction transaction) throws TransactionServiceException {
		return transactionService.create(transaction);
	}

	@RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET)
	public List<Transaction> getAllTransactions(@PathVariable Long cardId) throws CardNotFoundException {
		return transactionService.getAllTransactions(cardId);
	}

	@RequestMapping(value = "/capture/{transactionId}", method = RequestMethod.POST)
	public Transaction createTransaction(Merchant merchant, @PathVariable Long transactionId)
			throws MerchantException, TransactionNotFoundException, LackOfOwnershipException {
		return transactionService.captureTransaction(merchant, transactionId);
	}

}
