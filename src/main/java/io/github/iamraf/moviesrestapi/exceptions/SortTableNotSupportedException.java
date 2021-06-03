package io.github.iamraf.moviesrestapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SortTableNotSupportedException extends RuntimeException {

    public SortTableNotSupportedException(String message) {
        super(message);
    }
}