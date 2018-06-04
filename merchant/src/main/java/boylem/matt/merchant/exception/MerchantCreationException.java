package boylem.matt.merchant.exception;

public class MerchantCreationException extends Exception {

	public static final String ERROR_MESSAGE = "Failed to create a new Merchant";

	public MerchantCreationException() {
		super(ERROR_MESSAGE);
	}

}
