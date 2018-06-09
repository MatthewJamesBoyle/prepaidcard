package boylem.matt.merchant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import boylem.matt.merchant.exception.MerchantCreationException;
import utils.ErrorType;

@ControllerAdvice
/**
 * Controller advice for Merchant application. Globally handles errors for named
 * exceptions.
 * 
 * @author Matt Boyle
 *
 */
public class MerchantControllerExceptionHandler {

	@ExceptionHandler(value = { MerchantCreationException.class })
	/**
	 * Handles exceptions for Merchant service.
	 * 
	 * @param ex
	 *            Exception to handle.
	 * @param request
	 * @return ResponseEntity<errorType>
	 */
	protected ResponseEntity<ErrorType> handleError(MerchantCreationException ex, WebRequest request) {
		return new ResponseEntity<ErrorType>(new ErrorType(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
