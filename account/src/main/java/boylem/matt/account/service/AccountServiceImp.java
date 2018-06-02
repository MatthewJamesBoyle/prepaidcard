package boylem.matt.account.service;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Deposit;
import utils.ErrorType;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	public Long getBalance(Long id) {
		return accountDao.findById(id).getBalance();
	}

	@Override
	public ResponseEntity<?> deposit(Deposit deposit) {
		Account account = accountDao.findById(deposit.getAccountId());
		if (account == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("ERROR: Id =" + deposit.getAccountId() + " not found."),
					HttpStatus.BAD_REQUEST);
		}
		long newBalance = deposit.getDepositAmount() + account.getBalance();
		account.setBalance(newBalance);
		account.setAvailableBalance(account.getAvailableBalance() + deposit.getDepositAmount());
		accountDao.save(account);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

}
