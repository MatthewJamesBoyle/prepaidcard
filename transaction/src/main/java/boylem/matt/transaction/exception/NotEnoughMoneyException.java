package boylem.matt.transaction.exception;

/**
 * NotEnoughMoneyException
 * 
 * @author Matt Boyle
 *
 */
public class NotEnoughMoneyException extends TransactionServiceException {

	/**
	 * Error message thrown.
	 */
	private static final String MESSAGE = "There's not enough money your account to spend %s";

	/**
	 * Constructor
	 * 
	 * @param amount
	 *            Long
	 */
	public NotEnoughMoneyException(long amount) {
		super(String.format(MESSAGE, amount));
	}

}
