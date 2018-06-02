package boylem.matt.transaction.service;

import org.springframework.http.ResponseEntity;

import boylem.matt.transaction.domain.Transaction;

public interface TransactionService {

	ResponseEntity<?> create(Transaction transaction);
}
