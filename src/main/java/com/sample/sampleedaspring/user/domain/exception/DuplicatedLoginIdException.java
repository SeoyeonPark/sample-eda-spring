package com.sample.sampleedaspring.user.domain.exception;

public class DuplicatedLoginIdException extends RuntimeException {
    public DuplicatedLoginIdException(final String message) {
        super(message);
    }
}
