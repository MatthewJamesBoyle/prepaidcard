package boylem.matt.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CouldNotCreateAccountException;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	AccountDao accountDao;

	public Account getBalance(Long id) throws AccountNotFoundException {
		Account account = accountDao.findById(id);
		if (account == null) {
			throw new AccountNotFoundException(id);
		}
		return account;
	}

	public Account deposit(Deposit deposit) throws AccountNotFoundException {
		Account account = accountDao.findById(deposit.getAccountId());
		if (account == null) {
			throw new AccountNotFoundException(deposit.getAccountId());
		}
		long newBalance = deposit.getDepositAmount() + account.getBalance();
		account.setBalance(newBalance);
		account.setAvailableBalance(account.getAvailableBalance() + deposit.getDepositAmount());
		accountDao.save(account);
		return account;
	}

	public Account createAccount(Account newAcc) throws CouldNotCreateAccountException {
		if (newAcc == null) {
			throw new CouldNotCreateAccountException();
		}
		newAcc.setAvailableBalance(newAcc.getAvailableBalance());
		accountDao.save(newAcc);
		return newAcc;
	}

}
