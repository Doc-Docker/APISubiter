package com.subiter.backend.APISubiterBackend.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConflictException(String msg) {
        super(msg);
    }

    public ConflictException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
