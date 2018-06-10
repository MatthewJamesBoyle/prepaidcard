package boylem.matt.account.service;

import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Card;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CouldNotCreateAccountException;

/**
 * AccountService inferface.
 * 
 * @author Matt Boyle
 *
 */
public interface AccountService {

	/**
	 * get Balance.
	 * 
	 * @param id.
	 *            id of Account.
	 * @return Account.
	 * @throws AccountNotFoundException
	 */
	Account getBalance(Long id) throws AccountNotFoundException;

	/**
	 * Deposit into account.
	 * 
	 * @param deposit
	 * @return Account.
	 * @throws AccountNotFoundException
	 */
	Account deposit(Deposit deposit) throws AccountNotFoundException;

	/**
	 * create account.
	 * 
	 * @param newAcc
	 *            account to create.
	 * @return Account.
	 * @throws CouldNotCreateAccountException
	 */
	Account createAccount(Account newAcc) throws CouldNotCreateAccountException;

	/**
	 * increase Balance by amount.
	 * 
	 * @param cardId.
	 *            id of card to update.
	 * @param amount
	 *            to update account by.
	 * @return Account
	 * @throws AccountNotFoundException
	 */
	Account decreaseBalance(Long cardId, Long amount) throws AccountNotFoundException;

	/**
	 * authorizePayment.
	 * 
	 * @param id
	 *            id of account to update.
	 * @param amount
	 *            to check account has balance for.
	 * @return Account
	 * @throws AccountNotFoundException
	 */
	Account authorizePayment(long id, long amount) throws AccountNotFoundException;

	/**
	 * refund account.
	 * 
	 * @param cardId.
	 *            id of Card to refund.
	 * @param amount
	 *            amount to refund.
	 * @return Account.
	 * @throws AccountNotFoundException
	 */
	Account refund(Long cardId, Long amount) throws AccountNotFoundException;

}
