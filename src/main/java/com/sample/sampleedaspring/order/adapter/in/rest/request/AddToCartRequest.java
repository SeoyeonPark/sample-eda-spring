package com.sample.sampleedaspring.order.adapter.in.rest.request;

import com.sample.sampleedaspring.common.SelfValidating;
import com.sample.sampleedaspring.menu.domain.models.HotIced;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class AddToCartRequest extends SelfValidating<AddToCartRequest> {

    @NotNull
    private String loginId;

    @NotNull
    private String menuId;

    @NotNull
    private HotIced hotIced;

    @NotNull
    @Positive
    private Integer orderCount;

    @NotNull
    @Positive
    private Integer pricePerCup;
}
