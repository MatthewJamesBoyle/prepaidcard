package boylem.matt.account.exception;

public class CardNotFoundException extends Exception {

	private static final String MESSAGE = "Card not found with id %s";

	public CardNotFoundException(long id) {
		super(String.format(MESSAGE, id));
	}
}
