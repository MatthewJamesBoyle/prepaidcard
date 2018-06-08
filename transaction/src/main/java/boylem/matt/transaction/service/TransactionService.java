package boylem.matt.transaction.service;

import java.util.List;

import boylem.matt.transaction.domain.Merchant;
import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.exception.CardNotFoundException;
import boylem.matt.transaction.exception.LackOfOwnershipException;
import boylem.matt.transaction.exception.NotCapturableAmountException;
import boylem.matt.transaction.exception.TransactionNotFoundException;
import boylem.matt.transaction.exception.TransactionServiceException;

public interface TransactionService {

	Transaction create(Transaction transaction) throws TransactionServiceException;

	List<Transaction> getAllTransactions(Long accountId) throws CardNotFoundException;

	Transaction captureTransaction(Long merchantId, Long transactionId)
			throws TransactionNotFoundException, LackOfOwnershipException, TransactionServiceException;

	Transaction reverseCapture(Merchant merchant, Long transactionId, Long amount)
			throws TransactionNotFoundException, NotCapturableAmountException, LackOfOwnershipException, TransactionServiceException;

	Transaction refund(Long merchantId, Long transactionId, Long amount) throws TransactionNotFoundException,
			NotCapturableAmountException, LackOfOwnershipException, TransactionServiceException;

	Transaction capturePartialTransaction(Long merchantId, Long transactionId, Long amountToCapture)
			throws TransactionNotFoundException, LackOfOwnershipException, NotCapturableAmountException,
			TransactionServiceException;
}
