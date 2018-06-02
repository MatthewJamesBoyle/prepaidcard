package boylem.matt.account.service;

import boylem.matt.account.domain.Deposit;

public interface AccountService {

	Long getBalance(Long id);

	Long deposit(Deposit deposit);

}
