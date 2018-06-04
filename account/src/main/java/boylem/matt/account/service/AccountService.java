package boylem.matt.account.service;

import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;

public interface AccountService {

	Long getBalance(Long id);

	Account deposit(Deposit deposit) throws AccountNotFoundException;

}
