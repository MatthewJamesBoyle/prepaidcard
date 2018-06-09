package utils;

/**
 * 
 * @author Matt Boyle
 *
 */
public class ErrorType {

	/**
	 * Error message
	 */
	private String errorMessage;

	/**
	 * constructor
	 * 
	 * @param errorMessage
	 */
	public ErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * get errorMessage.
	 *
	 * @return String errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}