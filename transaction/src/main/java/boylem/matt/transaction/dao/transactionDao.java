package boylem.matt.transaction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.domain.TransactionStatus;

public interface transactionDao extends JpaRepository<Transaction, Long> {

	Transaction findById(Long transactionId);

	List<Transaction> findByCardId(Long cardId);

	public List<Transaction> findByCardIdAndStatus(Long cardId, TransactionStatus status);

}
