package boylem.matt.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.transaction.domain.Transaction;
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

}
