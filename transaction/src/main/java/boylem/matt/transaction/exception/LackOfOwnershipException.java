package boylem.matt.transaction.exception;

/**
 * LackOfOwnershipException
 * 
 * @author Matt Boyle
 *
 */
public class LackOfOwnershipException extends Exception {
	/**
	 * String thrown as error message
	 */
	private static final String ERROR_MESSAGE = "Merchant %s does not own, and therefore cannot collect transaction %s";

	/**
	 * Constructor
	 * 
	 * @param merchantId
	 *            Long
	 * @param transactionId
	 *            Long
	 */
	public LackOfOwnershipException(Long merchantId, Long transactionId) {
		super(String.format(ERROR_MESSAGE, merchantId, transactionId));

	}

}
