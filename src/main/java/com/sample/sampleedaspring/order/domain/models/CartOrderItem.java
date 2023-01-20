package com.sample.sampleedaspring.order.domain.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Value
public class CartOrderItem {
    @Getter
    @NonNull
    private MenuId menuId;

    @Getter
    @NonNull
    @Positive
    private Integer orderCount;

    @Getter
    @NonNull
    @PositiveOrZero
    private BigDecimal price;

    public CartOrderItem(
            @NonNull final MenuId menuId,
            @NonNull @Positive final Integer orderCount,
            @NonNull @PositiveOrZero final BigDecimal price) {
        this.menuId = menuId;
        this.orderCount = orderCount;
        this.price = price;
    }
}
