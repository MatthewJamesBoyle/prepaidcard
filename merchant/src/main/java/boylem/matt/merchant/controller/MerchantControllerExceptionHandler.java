package boylem.matt.merchant.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import boylem.matt.merchant.exception.MerchantCreationException;
import utils.ErrorType;

@ControllerAdvice
public class MerchantControllerExceptionHandler {

	@ExceptionHandler(value = { MerchantCreationException.class })
	protected ResponseEntity<ErrorType> handleConflict(MerchantCreationException ex, WebRequest request) {
		return new ResponseEntity<ErrorType>(new ErrorType(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
}
