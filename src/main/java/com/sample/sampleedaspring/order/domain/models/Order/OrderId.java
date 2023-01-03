package com.sample.sampleedaspring.order.domain.models.Order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter(AccessLevel.NONE)
public class OrderId {
    private String id;

    public OrderId() {
        this.id = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.S"));
    }
}
