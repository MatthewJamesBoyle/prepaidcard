package boylem.matt.account.service;

import org.springframework.http.ResponseEntity;

import boylem.matt.account.domain.Deposit;

public interface AccountService {

	Long getBalance(Long id);

	ResponseEntity<?> deposit(Deposit deposit);

}
