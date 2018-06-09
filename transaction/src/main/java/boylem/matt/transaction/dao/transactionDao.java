package boylem.matt.transaction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.domain.TransactionStatus;

/**
 * JPARepository for transactionDao
 * 
 * @author MattBoyle
 *
 */
public interface transactionDao extends JpaRepository<Transaction, Long> {

	/**
	 * find transaction by id.
	 * 
	 * @param transactionId
	 * @return Transaction
	 */
	Transaction findById(Long transactionId);

	/**
	 * Find transaction by Card Ids
	 * 
	 * @param cardId
	 * @return List<Transaction>
	 */
	List<Transaction> findByCardId(Long cardId);

	/**
	 * Find Transactions by cardIdAndStatus
	 * 
	 * @param cardId
	 * @param status
	 * @return List<Transaction> 
	 */
	public List<Transaction> findByCardIdAndStatus(Long cardId, TransactionStatus status);

}
