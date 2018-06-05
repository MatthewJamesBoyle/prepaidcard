package boylem.matt.transaction.exception;

public class LackOfOwnershipException extends Exception {
	private static final String ERROR_MESSAGE = "Merchant %s does not own, and therefore cannot collect transaction %s";

	public LackOfOwnershipException(Long merchantId, Long transactionId) {
		super(String.format(ERROR_MESSAGE, merchantId, transactionId));

	}

}
