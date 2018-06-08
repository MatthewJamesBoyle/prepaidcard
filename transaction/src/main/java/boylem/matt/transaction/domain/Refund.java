package boylem.matt.transaction.domain;

public class Refund {

	private Long merchantId;
	private Long transactionId;
	private Long amount;

	protected Refund() {

	}

	public Refund(Long merchantId, Long transactionId, Long amount) {
		this.merchantId = merchantId;
		this.transactionId = transactionId;
		this.amount = amount;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
