package boylem.matt.transaction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import boylem.matt.transaction.domain.Transaction;

public interface transactionDao extends JpaRepository<Transaction, Long> {

	Transaction findById(Long transactionId);

	List<Transaction> findByCardId(Long cardId);

}
