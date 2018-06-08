package boylem.matt.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CouldNotCreateAccountException;
import boylem.matt.account.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/balance/{accountNumber}", method = RequestMethod.GET)
	public Account getBalance(@PathVariable Long accountNumber) throws AccountNotFoundException {
		return accountService.getBalance(accountNumber);
	}

	@RequestMapping(value = "/balance", method = RequestMethod.POST)
	public Account postBalance(@Valid @RequestBody Deposit deposit) throws AccountNotFoundException {
		return accountService.deposit(deposit);

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Account createAccount(@Valid @RequestBody Account newAcc) throws CouldNotCreateAccountException {
		return accountService.createAccount(newAcc);
	}

	@RequestMapping(value = "/card/{cardId}/amount/{amount}/finalize", method = RequestMethod.POST)
	public Account updateBalances(@PathVariable Long cardId, @PathVariable Long amount)
			throws AccountNotFoundException {
		return accountService.updateBalances(cardId, amount);
	}

	@RequestMapping("/{id}/authorize/{amount}")
	public Account authorizePayment(@PathVariable("id") long id, @PathVariable("amount") long amount)
			throws AccountNotFoundException {
		return accountService.authorizePayment(id, amount);

	}

}
