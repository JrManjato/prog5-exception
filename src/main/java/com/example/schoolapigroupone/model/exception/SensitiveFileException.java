package com.example.schoolapigroupone.model.exception;

public class SensitiveFileException extends ApiException {

  public SensitiveFileException() {
    super(ExceptionType.CLIENT_EXCEPTION, "Access is denied due to sensitive information");
  }

  public SensitiveFileException(String message) {
    super(ExceptionType.CLIENT_EXCEPTION, message);
  }

}
