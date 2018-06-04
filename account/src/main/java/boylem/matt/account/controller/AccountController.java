package boylem.matt.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@Autowired
	AccountDao accountDao;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/balance/{accountNumber}", method = RequestMethod.GET)
	public Long getBalance(@PathVariable Long accountNumber) {
		return accountService.getBalance(accountNumber);
	}

	@RequestMapping(value = "/balance", method = RequestMethod.POST)
	public Account postBalance(@Valid @RequestBody Deposit deposit) throws AccountNotFoundException {
		return accountService.deposit(deposit);

	}

	@RequestMapping(value = "/account/create", method = RequestMethod.POST)
	public Account createAccount(@Valid @RequestBody Account newAcc) {
		return accountDao.save(newAcc);
	}

}
