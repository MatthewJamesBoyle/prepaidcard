package boylem.matt.transaction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.transaction.dao.transactionDao;
import boylem.matt.transaction.domain.Account;
import boylem.matt.transaction.domain.Deposit;
import boylem.matt.transaction.service.AccountService;

@RestController
public class TransactionController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/balance/{accountNumber}", method = RequestMethod.GET)
	public ResponseEntity<?> getBalance(@PathVariable Long accountNumber) {
		return accountService.getBalance(accountNumber);
	}

	@RequestMapping(value = "/balance", method = RequestMethod.POST)
	public ResponseEntity<?> postBalance(@Valid @RequestBody Deposit deposit) {
		return accountService.deposit(deposit);
	}

	@RequestMapping(value = "/account/create", method = RequestMethod.POST)
	public ResponseEntity<?> createAccount(@Valid @RequestBody Account newAcc) {
		return accountService.create(newAcc);
	}

}
