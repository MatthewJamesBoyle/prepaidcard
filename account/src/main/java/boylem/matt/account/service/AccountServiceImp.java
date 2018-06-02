package boylem.matt.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Deposit;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	public Long getBalance(Long id) {
		return accountDao.findById(id).getBalance();
	}

	@Override
	public Long deposit(Deposit deposit) {
		Account account = accountDao.findById(deposit.getAccountId());
		long newBalance = deposit.getDepositAmount() + account.getBalance();
		account.setBalance(newBalance);
		account.setAvailableBalance(account.getAvailableBalance() + deposit.getDepositAmount());
		accountDao.save(account);
		return newBalance;
	}

}
