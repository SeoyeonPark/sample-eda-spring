package com.sample.sampleedaspring.order.domain.models.Order;

public class DomainException extends RuntimeException{
    DomainException(final String message) {
        super(message);
    }
}
