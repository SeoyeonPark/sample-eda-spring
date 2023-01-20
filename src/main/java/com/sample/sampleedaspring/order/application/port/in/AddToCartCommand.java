package com.sample.sampleedaspring.order.application.port.in;

import com.sample.sampleedaspring.common.EnumPattern;
import com.sample.sampleedaspring.common.SelfValidating;
import com.sample.sampleedaspring.menu.domain.models.HotIced;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Value
@EqualsAndHashCode(callSuper = false)
public class AddToCartCommand extends SelfValidating<AddToCartCommand> {
    @NotNull
    private final String customerId;

    @NotNull
    private final String menuId;

    @NotNull
    @EnumPattern(regexp = "HOT|ICED")
    private final HotIced hotIced;

    @NotNull
    @Positive
    private final Integer number;

    @NotNull
    @Positive
    private final Integer pricePerCup;
}
