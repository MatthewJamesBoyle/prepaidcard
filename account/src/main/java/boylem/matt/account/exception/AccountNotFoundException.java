package boylem.matt.account.exception;

/**
 * AccountNotFoundException.
 * 
 * @author Matt Boyle
 *
 */
public class AccountNotFoundException extends Exception {

	/**
	 * Message.
	 */
	private static final String MESSAGE = "Account not found with id %s";

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            account id.
	 */
	public AccountNotFoundException(long id) {
		super(String.format(MESSAGE, id));
	}

}
