package com.devsu.account.handler.exception;

public class DuplicateEntityException extends IllegalArgumentException {

  public DuplicateEntityException(String message) {
    super(message);
  }
}
