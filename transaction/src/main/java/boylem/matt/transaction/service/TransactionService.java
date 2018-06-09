package boylem.matt.transaction.service;

import java.util.List;

import boylem.matt.transaction.domain.Merchant;
import boylem.matt.transaction.domain.Refund;
import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.exception.CardNotFoundException;
import boylem.matt.transaction.exception.LackOfOwnershipException;
import boylem.matt.transaction.exception.NotCapturableAmountException;
import boylem.matt.transaction.exception.TransactionNotFoundException;
import boylem.matt.transaction.exception.TransactionServiceException;

/**
 * TransactionService interface
 * 
 * @author Matt Boyle
 *
 */
public interface TransactionService {

	/**
	 * Create a transaction
	 * 
	 * @param transaction
	 * @return Transaction
	 * @throws TransactionServiceException
	 */
	Transaction create(Transaction transaction) throws TransactionServiceException;

	/**
	 * Get all transactions in the CLEARED state.
	 * 
	 * @param accountId
	 * @return List<Transaction>
	 * @throws CardNotFoundException
	 */
	List<Transaction> getAllTransactions(Long accountId) throws CardNotFoundException;

	/**
	 * Capture a transaction
	 * 
	 * @param merchantId
	 * @param transactionId
	 * 
	 * @return Transaction
	 * 
	 * @throws TransactionNotFoundException
	 * @throws LackOfOwnershipException
	 * @throws TransactionServiceException
	 */
	Transaction captureTransaction(Long merchantId, Long transactionId)
			throws TransactionNotFoundException, LackOfOwnershipException, TransactionServiceException;

	/**
	 * Partially capture a transaction
	 * 
	 * @param merchantId
	 * @param transactionId
	 * @param amountToCapture
	 * 
	 * @return Transaction
	 * 
	 * @throws TransactionNotFoundException
	 * @throws LackOfOwnershipException
	 * @throws NotCapturableAmountException
	 * @throws TransactionServiceException
	 */
	Transaction capturePartialTransaction(Long merchantId, Long transactionId, Long amountToCapture)
			throws TransactionNotFoundException, LackOfOwnershipException, NotCapturableAmountException,
			TransactionServiceException;

	/**
	 * Reverse a capture.
	 * 
	 * @param merchant
	 * @param transactionId
	 * @param amount
	 * 
	 * @return Transaction
	 * 
	 * @throws TransactionNotFoundException
	 * @throws NotCapturableAmountException
	 * @throws LackOfOwnershipException
	 * @throws TransactionServiceException
	 */
	Transaction reverseCapture(Merchant merchant, Long transactionId, Long amount) throws TransactionNotFoundException,
			NotCapturableAmountException, LackOfOwnershipException, TransactionServiceException;

	/**
	 * Refund a transaction
	 * 
	 * @param refund
	 * 
	 * @return Transaction
	 * 
	 * @throws TransactionNotFoundException
	 * @throws NotCapturableAmountException
	 * @throws LackOfOwnershipException
	 * @throws TransactionServiceException
	 */
	Transaction refund(Refund refund) throws TransactionNotFoundException, NotCapturableAmountException,
			LackOfOwnershipException, TransactionServiceException;

}
