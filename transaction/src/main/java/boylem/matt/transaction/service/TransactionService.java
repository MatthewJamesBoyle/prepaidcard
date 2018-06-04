package boylem.matt.transaction.service;

import org.springframework.http.ResponseEntity;

import boylem.matt.transaction.domain.Transaction;
import boylem.matt.transaction.exception.TransactionServiceException;

public interface TransactionService {

	Transaction create(Transaction transaction) throws TransactionServiceException;
}
