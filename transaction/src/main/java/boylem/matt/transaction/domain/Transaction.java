package boylem.matt.transaction.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
/**
 * Transaction Entity.
 * 
 * @author Matt Boyle
 *
 */
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * transaction id.
	 */
	private Long id;

	@Column
	@NotNull(message = "You must provide a card id.")
	/**
	 * card id.
	 */
	private Long cardId;

	@Column
	@NotNull(message = "You must provide a merchant id.")
	/**
	 * merchant id
	 */
	private Long merchantId;

	@Column
	@NotNull(message = "You must provide a transaction amount.")
	/**
	 * amount of transaction.
	 */
	Long transactionAmount;

	@Column
	/**
	 * The amount captured.
	 */
	Long capturedAmount;

	@Column
	@NotNull(message = "You must provide a transaction type")
	/**
	 * TransactionType.
	 */
	private TransactionType transactionType;

	@Column
	/**
	 * Status of transaction.
	 */
	private TransactionStatus status;

	@Column
	/**
	 * Timestamp when transaction was made.
	 */
	private Date timeStamp;

	/**
	 * Empty constructor.
	 */
	protected Transaction() {

	}

	/**
	 * Transaction constructor.
	 * 
	 * @param id
	 * @param cardId
	 * @param merchantId
	 * @param transactionAmount
	 * @param capturedAmount
	 * @param transactionType
	 * @param status
	 * @param timeStamp
	 */
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

	/**
	 * Transaction constructor.
	 * 
	 * @param id
	 * @param cardId
	 * @param merchantId
	 * @param transactionAmount
	 * @param transactionType
	 * @param status
	 * @param timeStamp
	 */
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

	/**
	 * Transaction constructor.
	 * 
	 * @param cardId
	 * @param merchantId
	 * @param transactionAmount
	 * @param status
	 */
	public Transaction(Long cardId, Long merchantId, Long transactionAmount, TransactionStatus status) {
		this.cardId = cardId;
		this.merchantId = merchantId;
		this.transactionAmount = transactionAmount;
		this.status = status;
	}

	/**
	 * Transaction constructor.
	 * 
	 * @param cardId
	 * @param merchantId
	 * @param amount
	 * @param transactionType
	 * @param transactionStatus
	 * @param date
	 */
	public Transaction(Long cardId, Long merchantId, Long amount, TransactionType transactionType,
			TransactionStatus transactionStatus, Date date) {
		this.cardId = cardId;
		this.merchantId = merchantId;
		this.capturedAmount = amount;
		this.transactionType = transactionType;
		this.status = transactionStatus;
		this.timeStamp = date;

	}

	/**
	 * get id
	 * 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * set id
	 * 
	 * @param id
	 *            Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get cardId
	 * 
	 * @return Long
	 */
	public Long getCardId() {
		return cardId;
	}

	/**
	 * set cardId
	 * 
	 * @param cardId
	 *            Long
	 */
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	/**
	 * get merchantId
	 * 
	 * @return Long
	 */
	public Long getMerchantId() {
		return merchantId;
	}

	/**
	 * set merchantId
	 * 
	 * @param merchantId
	 *            Long
	 */
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * get transactionAmount
	 * 
	 * @return Long
	 */
	public Long getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * set transactionAmount
	 * 
	 * @param transactionAmount
	 *            Long
	 */
	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * get capturedAmount
	 * 
	 * @return Long
	 */
	public Long getCapturedAmount() {
		return capturedAmount;
	}

	/**
	 * set Captured amount
	 * 
	 * @param capturedAmount
	 *            Long
	 */
	public void setCapturedAmount(Long capturedAmount) {
		this.capturedAmount = capturedAmount;
	}

	/**
	 * get TransactionType
	 * 
	 * @return TransactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * set TransactionType
	 * 
	 * @param transactionType
	 *            TransactionType
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * get TransactionStatus
	 * 
	 * @return TransactionStatus
	 */
	public TransactionStatus getStatus() {
		return status;
	}

	/**
	 * set TransactionStatus
	 * 
	 * @param status
	 *            TransactionStatus
	 */
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	/**
	 * Get transaction timestamp
	 * 
	 * @return Date
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Set transaction timestamp.
	 * 
	 * @param timeStamp
	 *            Date
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
