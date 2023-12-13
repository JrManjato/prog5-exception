package com.example.schoolapigroupone;

import com.example.schoolapigroupone.model.exception.BadFileTypeException;
import com.example.schoolapigroupone.model.exception.DuplicateFileException;
import com.example.schoolapigroupone.model.exception.FileNameInvalidException;
import com.example.schoolapigroupone.model.exception.LargeFileException;
import com.example.schoolapigroupone.model.exception.NotAuthorizedException;
import com.example.schoolapigroupone.model.exception.NotFoundException;
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
  public ResponseEntity<String> handleBadFileTypeException(BadFileTypeException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }

  @ExceptionHandler(FileNameInvalidException.class)
  public ResponseEntity<String> handleFileNameInvalidException(FileNameInvalidException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }

  @ExceptionHandler(DuplicateFileException.class)
  public ResponseEntity<String> handleDuplicateFileException(DuplicateFileException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }

  @ExceptionHandler(LargeFileException.class)
  public ResponseEntity<String> handleLargeFileException(LargeFileException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }
}