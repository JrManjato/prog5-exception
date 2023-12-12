package com.example.schoolapigroupone.model.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

  @Getter private final ExceptionType type;
  @Getter private final int errorCode;

  public ApiException(ExceptionType type, String message) {
    super(message);
    this.type = type;
    this.errorCode= 500;
  }

  public ApiException(ExceptionType type, Exception source) {
    super(source);
    this.type = type;
    this.errorCode= 500;
  }

  public ApiException(ExceptionType type, String message, int errorCode) {
    super(message);
    this.type = type;
    this.errorCode= errorCode;
  }

  public enum ExceptionType {
    CLIENT_EXCEPTION,
    SERVER_EXCEPTION
  }
}