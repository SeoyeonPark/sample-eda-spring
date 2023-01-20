package com.sample.sampleedaspring.order.domain.models;

import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Value
public class OrderId {
    @Getter
    private String value;

    public OrderId(String loginId) {
        this.value = loginId + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.S"));
    }
}
