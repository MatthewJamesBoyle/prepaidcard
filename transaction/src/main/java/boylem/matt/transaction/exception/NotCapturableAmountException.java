package boylem.matt.transaction.exception;

/**
 * NotCapturableAmountException
 * 
 * @author Matt Boyle
 *
 */
public class NotCapturableAmountException extends TransactionServiceException {

	/**
	 * Error message thrown.
	 */
	private static final String ERROR_MESSAGE = "Only %s is capturable of transaction %s. You tried to capture %s";

	/**
	 * Constructor
	 * 
	 * @param transactionId
	 *            Long
	 * @param capturedRemaining
	 *            Long
	 * @param amountToCapture
	 *            Long
	 */
	public NotCapturableAmountException(Long transactionId, Long capturedRemaining, Long amountToCapture) {
		super(String.format(ERROR_MESSAGE, capturedRemaining, transactionId, amountToCapture));

	}

}
