package boylem.matt.transaction.exception;

public class NotCapturableAmountException extends TransactionServiceException {

	private static final String ERROR_MESSAGE = "Only %s is capturable of transcation %s. You tried to capture %s";

	public NotCapturableAmountException(Long transactionId, Long capturedRemaining, Long amountToCapture) {
		super(String.format(ERROR_MESSAGE, capturedRemaining, transactionId, amountToCapture));

	}

}
