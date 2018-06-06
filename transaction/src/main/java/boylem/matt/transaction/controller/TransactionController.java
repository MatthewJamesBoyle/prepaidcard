package boylem.matt.transaction.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.transaction.domain.Merchant;
import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.exception.CardNotFoundException;
import boylem.matt.transaction.exception.LackOfOwnershipException;
import boylem.matt.transaction.exception.MerchantException;
import boylem.matt.transaction.exception.NotCapturableAmountException;
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
	public Transaction createTransaction(@RequestBody @Valid Transaction transaction)
			throws TransactionServiceException {
		return transactionService.create(transaction);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Transaction> getAllTransactions(@PathVariable Long cardId) throws CardNotFoundException {
		return transactionService.getAllTransactions(cardId);
	}

	@RequestMapping(value = "/capture/{transactionId}", method = RequestMethod.POST)
	public Transaction captureTransaction(Merchant merchant, @PathVariable Long transactionId)
			throws MerchantException, TransactionNotFoundException, LackOfOwnershipException {
		return transactionService.captureTransaction(merchant, transactionId);
	}

	@RequestMapping(value = "/capture/{transactionId}/{amount}", method = RequestMethod.POST)
	public Transaction capturePartialTransaction(Merchant merchant, @PathVariable Long transactionId,
			@PathVariable Long amount) throws MerchantException, TransactionNotFoundException, LackOfOwnershipException,
			NotCapturableAmountException {
		return transactionService.capturePartialTransaction(merchant, transactionId, amount);
	}

	@RequestMapping(value = "/reverseCapture/{transactionId}/{amount}", method = RequestMethod.POST)
	public Transaction reversePartialTransaction(Merchant merchant, @PathVariable Long transactionId,
			@PathVariable Long amount) throws MerchantException, TransactionNotFoundException, LackOfOwnershipException,
			NotCapturableAmountException {
		return transactionService.reverseCapture(merchant, transactionId, amount);
	}

	@RequestMapping(value = "/refund/{transactionId}/{amount}", method = RequestMethod.POST)
	public Transaction refundTransaction(Merchant merchant, @PathVariable Long transactionId, @PathVariable Long amount)
			throws MerchantException, LackOfOwnershipException, TransactionServiceException {
		return transactionService.refund(merchant, transactionId, amount);
	}

}
