package boylem.matt.account.exception;

/**
 * CardNotFoundException.
 * 
 * @author Matt Boyle.
 *
 */
public class CardNotFoundException extends Exception {

	/**
	 * Exception Message.
	 */
	private static final String MESSAGE = "Card not found with id %s";

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            id of card.
	 */
	public CardNotFoundException(long id) {
		super(String.format(MESSAGE, id));
	}
}
