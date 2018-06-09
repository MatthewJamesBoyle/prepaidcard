package boylem.matt.transaction.domain;

/**
 * Refund Bean
 * 
 * @author Matt Boyle
 *
 */
public class Refund {

	/**
	 * id of Merchant
	 */
	private Long merchantId;

	/**
	 * id of transaction.
	 */
	private Long transactionId;

	/**
	 * amount of refund
	 */
	private Long amount;

	/**
	 * Empty Constructor.
	 */
	protected Refund() {

	}

	/**
	 * Constructor
	 * 
	 * @param merchantId
	 * @param transactionId
	 * @param amount
	 */
	public Refund(Long merchantId, Long transactionId, Long amount) {
		this.merchantId = merchantId;
		this.transactionId = transactionId;
		this.amount = amount;
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
	 * get transactionId
	 * 
	 * @return Long
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	/**
	 * set transactionId
	 * 
	 * @param transactionId
	 *            Long
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * get amount.
	 * 
	 * @return Long
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * set amount.
	 * 
	 * 
	 * @param amount
	 *            Amount
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
