package boylem.matt.transaction.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long cardId;

	@Column
	private Long merchantId;

	@Column
	Long amount;

	@Column
	private Long transactionType;

	@Column
	private TransactionStatus status;

	@Column
	private Date timeStamp;

	protected Transaction() {

	}

	public Transaction(Long cardId, Long merchantId, Long amount, Long transactionType, TransactionStatus status) {
		this.cardId = cardId;
		this.merchantId = merchantId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Long transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
