package com.sample.sampleedaspring.order.domain.models;

import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Value
public class OrderId {
    @Getter
    private String value;

    public OrderId (String orderId) {
        this.value = orderId;
    }

    public static OrderId InitializeId(String loginId) {
        return new OrderId(loginId + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS")));
    }
}
