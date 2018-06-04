package boylem.matt.account.exception;

public class AccountNotFoundException extends Exception {

	private static final String MESSAGE = "Account not found with id %s";

	public AccountNotFoundException(long id) {
		super(String.format(MESSAGE, id));
	}

}
