package com.sample.sampleedaspring.order.adapter.in.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.sampleedaspring.common.SelfValidating;
import com.sample.sampleedaspring.menu.domain.models.HotIced;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CreateDirectOrderRequest extends SelfValidating<CreateDirectOrderRequest> {

    @NotNull
    @JsonProperty("loginId")
    private String loginId;

    @NotNull
    @JsonProperty("menuId")
    private String menuId;

    @NotNull
    @JsonProperty("menuName")
    private String menuName;

    @NotNull
    @JsonProperty("hotIced")
    private HotIced hotIced;

    @NotNull
    @Positive
    @JsonProperty("orderCount")
    private Integer orderCount;

    @NotNull
    @Positive
    @JsonProperty("price")
    private Integer price;
}
