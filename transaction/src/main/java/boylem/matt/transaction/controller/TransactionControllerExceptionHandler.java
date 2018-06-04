package boylem.matt.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import boylem.matt.transaction.exception.TransactionServiceException;
import utils.ErrorType;

@ControllerAdvice
public class TransactionControllerExceptionHandler {

	@ExceptionHandler(value = TransactionServiceException.class)
	protected ResponseEntity<ErrorType> handleConflict(TransactionServiceException ex, WebRequest request) {
		return new ResponseEntity<ErrorType>(new ErrorType(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
