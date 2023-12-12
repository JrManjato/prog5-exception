package com.example.schoolapigroupone;

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
}