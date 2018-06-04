package boylem.matt.transaction.exception;

public class CardNotFoundException extends TransactionServiceException {

	private static final String ERROR_MESSAGE = "Card not found with id %s";

	public CardNotFoundException(Long cardId) {
		super(String.format(ERROR_MESSAGE, cardId));

	}

}
