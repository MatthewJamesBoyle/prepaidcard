package boylem.matt.transaction.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boylem.matt.transaction.domain.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	public ResponseEntity<?> create(Transaction transaction) {
		return null;
	}

}
