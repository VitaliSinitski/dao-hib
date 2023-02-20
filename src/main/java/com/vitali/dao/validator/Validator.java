package com.vitali.dao.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
