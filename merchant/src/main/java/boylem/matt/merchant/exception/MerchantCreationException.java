package boylem.matt.merchant.exception;

/**
 * MerchantCreationException
 * 
 * @author Matt Boyle
 *
 */
public class MerchantCreationException extends Exception {

	/**
	 * Error message that is strong.
	 */
	public static final String ERROR_MESSAGE = "Failed to create a new Merchant";

	/**
	 * Constructor.
	 */
	public MerchantCreationException() {
		super(ERROR_MESSAGE);
	}

}
