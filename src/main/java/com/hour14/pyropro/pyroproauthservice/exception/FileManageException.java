package com.hour14.pyropro.pyroproauthservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class FileManageException extends RuntimeException{

    private static final long serialVersionID = 1L;

    public FileManageException(String message) {
        super(message);
    }
}
