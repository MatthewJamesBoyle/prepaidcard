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
import boylem.matt.transaction.domain.Refund;
import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.exception.CardNotFoundException;
import boylem.matt.transaction.exception.LackOfOwnershipException;
import boylem.matt.transaction.exception.MerchantException;
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

	@RequestMapping(value = "/{cardId}", method = RequestMethod.GET)
	public List<Transaction> getAllTransactions(@PathVariable("cardId") Long cardId) throws CardNotFoundException {
		return transactionService.getAllTransactions(cardId);
	}

	@RequestMapping(value = "/capture/{transactionId}/merchant/{merchantId}", method = RequestMethod.POST)
	public Transaction captureTransaction(@PathVariable Long transactionId, @PathVariable Long merchantId)
			throws MerchantException, LackOfOwnershipException, TransactionServiceException {
		return transactionService.captureTransaction(merchantId, transactionId);
	}

	@RequestMapping(value = "/capture/{transactionId}/amount/{amount}/merchant/{merchantId}", method = RequestMethod.POST)
	public Transaction capturePartialTransaction(Merchant merchant, @PathVariable Long transactionId,
			@PathVariable Long amount, @PathVariable Long merchantId)
			throws MerchantException, LackOfOwnershipException, TransactionServiceException {
		return transactionService.capturePartialTransaction(merchantId, transactionId, amount);
	}

	@RequestMapping(value = "/reverseCapture/{transactionId}/{amount}", method = RequestMethod.POST)
	public Transaction reversePartialTransaction(Merchant merchant, @PathVariable Long transactionId,
			@PathVariable Long amount) throws MerchantException, LackOfOwnershipException, TransactionServiceException {
		return transactionService.reverseCapture(merchant, transactionId, amount);
	}

	@RequestMapping(value = "/refund", method = RequestMethod.POST)
	public Transaction refundTransaction(@Valid @RequestBody Refund refund)
			throws MerchantException, LackOfOwnershipException, TransactionServiceException {
		return transactionService.refund(refund);
	}

}
