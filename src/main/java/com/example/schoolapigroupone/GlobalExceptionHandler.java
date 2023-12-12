package com.example.schoolapigroupone;

import com.example.schoolapigroupone.model.exception.BadFileTypeException;
import com.example.schoolapigroupone.model.exception.NotAuthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.schoolapigroupone.model.exception.SensitiveFileException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(SensitiveFileException.class)
  public ResponseEntity<String> handleSensitiveFileException(SensitiveFileException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }

  @ExceptionHandler(NotAuthorizedException.class)
  public ResponseEntity<String> handleNotAuthorizedException(NotAuthorizedException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }

  @ExceptionHandler(BadFileTypeException.class)
  public ResponseEntity<String> handleBadFileTypeExceptionException(BadFileTypeException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }
}