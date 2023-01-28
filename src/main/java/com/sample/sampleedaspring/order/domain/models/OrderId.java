package com.sample.sampleedaspring.order.domain.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Value
public class OrderId {
    @Getter
    private Long value;

    public OrderId(final Long value) {
        this.value = value;
    }
}
