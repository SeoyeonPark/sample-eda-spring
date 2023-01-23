package com.sample.sampleedaspring.order.adapter.in.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Data
public class PreparedOrderMenuRequest {

    @NotNull
    @JsonProperty("orderId")
    private String orderId;
}
