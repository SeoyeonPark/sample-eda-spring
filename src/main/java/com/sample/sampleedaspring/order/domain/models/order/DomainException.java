package com.sample.sampleedaspring.order.domain.models.order;

public class DomainException extends RuntimeException{
    DomainException(final String message) {
        super(message);
    }
}
