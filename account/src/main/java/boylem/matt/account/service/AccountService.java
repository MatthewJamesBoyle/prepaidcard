package boylem.matt.account.service;

import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Card;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CouldNotCreateAccountException;

public interface AccountService {

	Account getBalance(Long id) throws AccountNotFoundException;

	Account deposit(Deposit deposit) throws AccountNotFoundException;

	Account createAccount(Account newAcc) throws CouldNotCreateAccountException;

	Account updateBalances(long cardId, long amount) throws AccountNotFoundException;

}
