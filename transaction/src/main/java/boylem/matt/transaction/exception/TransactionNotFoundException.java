package boylem.matt.transaction.exception;

/**
 * TransactionNotFoundException
 * 
 * @author Matt Boyle
 *
 */
public class TransactionNotFoundException extends TransactionServiceException {

	/**
	 * error messages thrown.
	 */
	private static final String ERROR_MESSAGE = "Transaction not found with id %s";

	/**
	 * Constructor
	 * 
	 * @param cardId
	 *            Long
	 */
	public TransactionNotFoundException(Long cardId) {
		super(String.format(ERROR_MESSAGE, cardId));

	}

}
