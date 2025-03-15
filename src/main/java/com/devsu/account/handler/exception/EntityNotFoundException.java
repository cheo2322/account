package com.devsu.account.handler.exception;

public class EntityNotFoundException extends IllegalArgumentException {

  public EntityNotFoundException(String message) {
    super(message);
  }
}
