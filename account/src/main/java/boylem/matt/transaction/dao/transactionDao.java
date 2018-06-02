package boylem.matt.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import boylem.matt.transaction.domain.Account;
import boylem.matt.transaction.domain.Transaction;

public interface transactionDao extends JpaRepository<Transaction, Long> {

	Transaction findById(Long transactionId);

}
