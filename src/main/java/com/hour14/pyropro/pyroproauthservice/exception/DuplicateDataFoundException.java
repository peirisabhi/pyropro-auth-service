package com.hour14.pyropro.pyroproauthservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateDataFoundException extends RuntimeException{

    private static final long serialVersionID = 1L;

    public DuplicateDataFoundException(String message) {
        super(message);
    }
}
