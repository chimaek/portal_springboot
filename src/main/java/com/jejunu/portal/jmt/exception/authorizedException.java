package com.jejunu.portal.jmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED,reason = "Unauthorized")
public class authorizedException extends Exception {
    public authorizedException(String message) {
        super(message);
    }
}
