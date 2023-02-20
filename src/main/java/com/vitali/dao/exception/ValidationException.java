package com.vitali.dao.exception;

import lombok.Getter;
import com.vitali.dao.validator.Error;

import java.util.List;

public class ValidationException extends RuntimeException {

    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }

}
