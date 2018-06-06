package boylem.matt.account.exception;

public class CouldNotCreateAccountException extends Exception {

	private static final String MESSAGE = "Failed to create account";

	public CouldNotCreateAccountException() {
		super(String.format(MESSAGE));
	}

}
