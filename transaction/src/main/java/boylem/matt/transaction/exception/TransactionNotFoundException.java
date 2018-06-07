package boylem.matt.transaction.exception;

public class TransactionNotFoundException extends TransactionServiceException {

	private static final String ERROR_MESSAGE = "Transaction not found with id %s";

	public TransactionNotFoundException(Long cardId) {
		super(String.format(ERROR_MESSAGE, cardId));

	}

}
