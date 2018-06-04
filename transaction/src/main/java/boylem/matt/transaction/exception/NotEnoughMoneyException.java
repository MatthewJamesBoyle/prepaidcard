package boylem.matt.transaction.exception;

public class NotEnoughMoneyException extends TransactionServiceException {

	private static final String MESSAGE = "There's not enough money your account to spend %s";

	public NotEnoughMoneyException(long amount) {
		super(String.format(MESSAGE, amount));
	}

}
