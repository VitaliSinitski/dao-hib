package com.vitali.dao.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
