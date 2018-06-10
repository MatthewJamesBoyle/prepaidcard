package boylem.matt.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.dao.CardDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CouldNotCreateAccountException;

/**
 * 
 * @author Matt Boyle
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	/**
	 * injected account Dao.
	 */
	AccountDao accountDao;

	@Autowired
	/**
	 * Injected cardDao.
	 */
	CardDao cardDao;

	/**
	 * get Balance.
	 * 
	 * @param id.
	 *            id of Account.
	 * @return Account.
	 * @throws AccountNotFoundException
	 */
	public Account getBalance(Long id) throws AccountNotFoundException {
		Account account = accountDao.findById(id);
		if (account == null) {
			throw new AccountNotFoundException(id);
		}
		return account;
	}

	/**
	 * Deposit into account.
	 * 
	 * @param deposit
	 * @return Account.
	 * @throws AccountNotFoundException
	 */
	public Account deposit(Deposit deposit) throws AccountNotFoundException {
		Account account = accountDao.findById(deposit.getAccountId());
		if (account == null) {
			throw new AccountNotFoundException(deposit.getAccountId());
		}
		account.setBalance(deposit.getDepositAmount() + account.getBalance());
		account.setAvailableBalance(account.getAvailableBalance() + deposit.getDepositAmount());
		accountDao.save(account);
		return account;
	}

	/**
	 * create account.
	 * 
	 * @param newAcc
	 *            account to create.
	 * @return Account.
	 * @throws CouldNotCreateAccountException
	 */
	public Account createAccount(Account newAcc) throws CouldNotCreateAccountException {
		if (newAcc == null) {
			throw new CouldNotCreateAccountException();
		}
		newAcc.setAvailableBalance(newAcc.getBalance());
		accountDao.save(newAcc);
		return newAcc;
	}

	/**
	 * decrease Balance by amount.
	 * 
	 * @param cardId.
	 *            id of card to update.
	 * @param amount
	 *            to update account by.
	 * @return Account
	 * @throws AccountNotFoundException
	 */
	public Account decreaseBalance(Long cardId, Long amount) throws AccountNotFoundException {
		Account account = cardDao.findCardById(cardId).getAccount();
		if (account == null) {
			throw new AccountNotFoundException(cardId);
		}
		account.setBalance(account.getBalance() - amount);
		accountDao.save(account);
		return account;
	}

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
	public Account authorizePayment(long cardId, long amount) throws AccountNotFoundException {
		Account account = cardDao.findCardById(cardId).getAccount();
		if (account == null) {
			throw new AccountNotFoundException(cardId);
		}
		account.setAvailableBalance(account.getAvailableBalance() - amount);
		accountDao.save(account);
		return account;

	}

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
	public Account refund(Long cardId, Long amount) throws AccountNotFoundException {
		Account account = cardDao.findCardById(cardId).getAccount();
		if (account == null) {
			throw new AccountNotFoundException(cardId);
		}
		account.setAvailableBalance(account.getAvailableBalance() + amount);
		accountDao.save(account);
		return account;
	}

}
