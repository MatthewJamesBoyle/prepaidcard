package boylem.matt.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import boylem.matt.transaction.exception.LackOfOwnershipException;
import boylem.matt.transaction.exception.MerchantException;
import boylem.matt.transaction.exception.NotCapturableAmountException;
import boylem.matt.transaction.exception.NotEnoughMoneyException;
import boylem.matt.transaction.exception.TransactionNotFoundException;
import boylem.matt.transaction.exception.TransactionServiceException;
import utils.ErrorType;

@ControllerAdvice
/**
 * ControllerAdvice for Transaction service.
 * 
 * @author Matt Boyle
 *
 */
public class TransactionControllerExceptionHandler {

	@ExceptionHandler(value = { TransactionServiceException.class, NotEnoughMoneyException.class,
			LackOfOwnershipException.class, MerchantException.class, NotCapturableAmountException.class,
			NotEnoughMoneyException.class, TransactionNotFoundException.class })
	/**
	 * Handles named Exceptions for Transaction service.
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity<ErrorType>
	 */
	protected ResponseEntity<ErrorType> handleExceptions(TransactionServiceException ex, WebRequest request) {
		return new ResponseEntity<ErrorType>(new ErrorType(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
