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

/**
 * AccountController.
 * 
 * @author Matt Boyle
 *
 */
@RestController
public class AccountController {

	@Autowired
	/**
	 * Injection of AccountService.
	 */
	AccountService accountService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	/**
	 * Simple endpoint to do a health check.
	 * 
	 * @return String
	 */
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/balance/{accountNumber}", method = RequestMethod.GET)
	/**
	 * Gets a users balance.
	 * 
	 * @param accountNumber
	 *            The users account number.
	 * @return Account
	 * @throws AccountNotFoundException
	 *             thrown if the account does not exist.
	 */
	public Account getBalance(@PathVariable Long accountNumber) throws AccountNotFoundException {
		return accountService.getBalance(accountNumber);
	}

	@RequestMapping(value = "/balance", method = RequestMethod.POST)
	/**
	 * Post request to update a users balance.
	 * 
	 * @param deposit
	 *            deposit information.
	 * @return Account
	 * @throws AccountNotFoundException
	 *             thrown if account isn't found.
	 */
	public Account postBalance(@Valid @RequestBody Deposit deposit) throws AccountNotFoundException {
		return accountService.deposit(deposit);

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	/**
	 * Method used for creating an account.
	 * 
	 * @param newAcc
	 *            new account information
	 * @return Account.
	 * @throws CouldNotCreateAccountException
	 *             thrown if creation fails.
	 */
	public Account createAccount(@Valid @RequestBody Account newAcc) throws CouldNotCreateAccountException {
		return accountService.createAccount(newAcc);
	}

	@RequestMapping(value = "/card/{cardId}/amount/{amount}/finalize", method = RequestMethod.GET)
	/**
	 * Decreases a users balance by amount.
	 * 
	 * @param cardId
	 *            card belonging to account.
	 * @param amount
	 *            amount to update account by.
	 * @return Account.
	 * @throws AccountNotFoundException
	 *             thrown if account isn't found.
	 */
	public Account updateBalances(@PathVariable Long cardId, @PathVariable Long amount)
			throws AccountNotFoundException {
		return accountService.decreaseBalance(cardId, amount);
	}

	@RequestMapping("/{id}/authorize/{amount}")
	/**
	 * Authorises a transaction by checking if the account has enough available
	 * balance.
	 * 
	 * @param cardId
	 *            id of card to update.
	 * @param amount
	 *            amount to be authorized.
	 * @return Account
	 * @throws AccountNotFoundException
	 *             thrown if account not found.
	 */
	public Account authorizePayment(@PathVariable("cardId") long cardId, @PathVariable("amount") long amount)
			throws AccountNotFoundException {
		return accountService.authorizePayment(cardId, amount);
	}

	@RequestMapping(value = "/refund/{cardId}/{amount}/updateBalance", method = RequestMethod.GET)
	/**
	 * refund an account for amount.
	 * 
	 * @param cardId
	 *            id of card to refund.
	 * @param amount
	 *            amount to refund to card.
	 * @return Account.
	 * @throws AccountNotFoundException
	 *             thrown if account not found.
	 */
	public Account refund(@PathVariable("cardId") Long cardId, @PathVariable("amount") Long amount)
			throws AccountNotFoundException {
		return accountService.refund(cardId, amount);
	}

}
