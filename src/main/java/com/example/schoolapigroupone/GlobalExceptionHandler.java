package com.example.schoolapigroupone;

import com.example.schoolapigroupone.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

  @ExceptionHandler(TooManyRequestException.class)
  public ResponseEntity<String> handleTooManyRequestException(TooManyRequestException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }

  @ExceptionHandler(NotImplementedException.class)
  public ResponseEntity<String> handleNotImplementedException(NotImplementedException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }
  @ExceptionHandler(ForLegalReasonException.class)
  public ResponseEntity<String> handleForLegalReasonException(ForLegalReasonException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }
  @ExceptionHandler(ServerErrorException.class)
  public ResponseEntity<String> handleServerErrorException(ServerErrorException ex) {
    String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
    return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
  }
}