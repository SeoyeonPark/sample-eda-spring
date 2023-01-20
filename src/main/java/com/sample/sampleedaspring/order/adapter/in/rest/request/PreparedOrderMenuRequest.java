package com.sample.sampleedaspring.order.adapter.in.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PreparedOrderMenuRequest {
    @Getter
    @NotNull
    private final String orderId;
}
