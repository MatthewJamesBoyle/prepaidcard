package boylem.matt.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import boylem.matt.transaction.domain.Account;

public interface transactionDao extends JpaRepository<Account, Long> {

	Account findById(Long accId);

}
