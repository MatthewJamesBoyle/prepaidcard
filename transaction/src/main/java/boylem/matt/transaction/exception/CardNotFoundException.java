package boylem.matt.transaction.exception;

/**
 * Card not found exception
 * 
 * @author Matt Boyle
 *
 */
public class CardNotFoundException extends TransactionServiceException {

	/**
	 * Message thrown.
	 */
	private static final String ERROR_MESSAGE = "Card not found with id %s";

	/**
	 * Constructor
	 * 
	 * @param cardId
	 *            Long
	 */
	public CardNotFoundException(Long cardId) {
		super(String.format(ERROR_MESSAGE, cardId));

	}

}
