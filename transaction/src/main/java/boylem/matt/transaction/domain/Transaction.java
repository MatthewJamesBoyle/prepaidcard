package boylem.matt.transaction.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long cardId;

	private Long merchantId;

	private Long transactionType;

	private TransactionStatus status;

	private Date timeStamp;

}
