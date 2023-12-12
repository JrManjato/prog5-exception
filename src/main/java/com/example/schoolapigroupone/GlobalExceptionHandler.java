package com.example.schoolapigroupone;

import com.example.schoolapigroupone.model.exception.ApiException;
import com.example.schoolapigroupone.model.exception.SensitiveFileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleApiException(ApiException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex.getErrorCode() == 400) {
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(ex.getMessage(), status);
    }
    @ExceptionHandler(SensitiveFileException.class)
    public ResponseEntity<String> handleSensitiveFileException(SensitiveFileException ex) {
        String errorMessage = "HTTP " + ex.getHttpStatus().value() + " " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
    }
}
