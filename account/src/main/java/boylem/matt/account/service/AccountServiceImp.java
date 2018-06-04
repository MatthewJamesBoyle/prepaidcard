package boylem.matt.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	public Long getBalance(Long id) {
		return accountDao.findById(id).getBalance();
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

}
