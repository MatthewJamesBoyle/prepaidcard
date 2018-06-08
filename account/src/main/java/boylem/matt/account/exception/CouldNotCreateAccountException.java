package boylem.matt.account.exception;

/**
 * CouldNotCreateAccountException
 * 
 * @author Matt Boyle
 *
 */
public class CouldNotCreateAccountException extends Exception {

	/**
	 * Exception Message.
	 */
	private static final String MESSAGE = "Failed to create account";

	/**
	 * Constructor.
	 */
	public CouldNotCreateAccountException() {
		super(String.format(MESSAGE));
	}

}
