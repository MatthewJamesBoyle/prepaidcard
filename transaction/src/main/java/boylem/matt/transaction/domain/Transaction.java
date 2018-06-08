package boylem.matt.transaction.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@NotNull(message = "You must provide a card id.")
	private Long cardId;

	@Column
	@NotNull(message = "You must provide a merchant id.")
	private Long merchantId;

	@Column
	@NotNull(message = "You must provide a transaction amount.")
	Long transactionAmount;

	@Column
	Long capturedAmount;

	@Column
	@NotNull(message = "You must provide a transaction type")
	private TransactionType transactionType;

	@Column
	private TransactionStatus status;

	@Column
	private Date timeStamp;

	protected Transaction() {

	}

	public Transaction(Long id, Long cardId, Long merchantId, Long transactionAmount, Long capturedAmount,
			TransactionType transactionType, TransactionStatus status, Date timeStamp) {
		this.id = id;
		this.cardId = cardId;
		this.merchantId = merchantId;
		this.transactionAmount = transactionAmount;
		this.capturedAmount = capturedAmount;
		this.transactionType = transactionType;
		this.status = status;
		this.timeStamp = timeStamp;
	}

	public Transaction(Long id, Long cardId, Long merchantId, Long transactionAmount, TransactionType transactionType,
			TransactionStatus status, Date timeStamp) {
		this.id = id;
		this.cardId = cardId;
		this.merchantId = merchantId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.status = status;
		this.timeStamp = timeStamp;
	}

	public Transaction(Long cardId, Long merchantId, Long transactionAmount, TransactionStatus status) {
		this.cardId = cardId;
		this.merchantId = merchantId;
		this.transactionAmount = transactionAmount;
		this.status = status;
	}

	public Transaction(Long cardId, Long merchantId, Long amount, TransactionType transactionType,
			TransactionStatus transactionStatus, Date date) {
		this.cardId = cardId;
		this.merchantId = merchantId;
		this.capturedAmount = amount;
		this.transactionType = transactionType;
		this.status = transactionStatus;
		this.timeStamp = date;

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

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Long getCapturedAmount() {
		return capturedAmount;
	}

	public void setCapturedAmount(Long capturedAmount) {
		this.capturedAmount = capturedAmount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
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
