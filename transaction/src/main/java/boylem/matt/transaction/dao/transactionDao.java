package boylem.matt.transaction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import boylem.matt.transaction.domain.Transaction;

public interface transactionDao extends JpaRepository<Transaction, Long> {

	Transaction findById(Long transactionId);

	List<Transaction> findByCardId(Long cardId);

	@Query("SELECT t FROM Transaction t WHERE status='CLEARED' AND  id = :cardId")
	public List<Transaction> findByCardIdWhereCleared(@Param("cardId") Long cardId);

}
