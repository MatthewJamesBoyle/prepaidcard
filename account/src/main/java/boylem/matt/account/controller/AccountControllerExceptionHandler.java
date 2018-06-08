package boylem.matt.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CardNotFoundException;
import boylem.matt.account.exception.CouldNotCreateAccountException;
import utils.ErrorType;

@ControllerAdvice
/**
 * AccountControllerExceptionHandler Converts named exceptions into a RESTful
 * format.
 * 
 * @author Matt Boyle
 *
 */
public class AccountControllerExceptionHandler {

	@ExceptionHandler(value = { AccountNotFoundException.class, CardNotFoundException.class,
			CouldNotCreateAccountException.class })
	/**
	 * handleError. catches AccountNotFoundException,CardNotFoundException and
	 * CouldNotCreateAccountException and returns a JSON response.
	 * 
	 * @param ex
	 *            the thrown exception.
	 * @param request
	 *            The request.
	 * @return ResponsEntity<ErrorType>
	 */
	protected ResponseEntity<ErrorType> handleError(Exception ex, WebRequest request) {
		return new ResponseEntity<ErrorType>(new ErrorType(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
