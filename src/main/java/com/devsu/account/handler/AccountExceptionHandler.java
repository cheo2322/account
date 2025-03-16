package com.devsu.account.handler;

import com.devsu.account.handler.exception.DuplicateEntityException;
import com.devsu.account.handler.exception.EntityNotFoundException;
import com.devsu.account.handler.exception.IllegalMovementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountExceptionHandler {

  @ExceptionHandler(DuplicateEntityException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<AccountError> handleDuplicateEntityException(DuplicateEntityException ex) {
    return new ResponseEntity<>(new AccountError(ex.getMessage()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<AccountError> handleEntityNotFoundException(EntityNotFoundException ex) {
    return new ResponseEntity<>(new AccountError(ex.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(IllegalMovementException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<AccountError> handleMovementEqualToZeroException(
      IllegalMovementException ex) {
    return new ResponseEntity<>(new AccountError("Movement equal to zero."), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<AccountError> handleUnexpectedException(Exception ex) {
    return new ResponseEntity<>(
        new AccountError("An unexpected error occurred. Please try again later."),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
