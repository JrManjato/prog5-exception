package com.example.schoolapigroupone.model.exception;

import org.springframework.http.HttpStatus;

public class ServiceUnavailableException extends ApiException{
    private final HttpStatus httpStatus;

    public ServiceUnavailableException() {
        super(ExceptionType.CLIENT_EXCEPTION, "The service is unavailable");
        this.httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
    }

    public ServiceUnavailableException(String message, HttpStatus httpStatus) {
        super(ExceptionType.CLIENT_EXCEPTION, message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
