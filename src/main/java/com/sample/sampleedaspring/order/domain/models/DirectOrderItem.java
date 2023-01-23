package com.sample.sampleedaspring.order.domain.models;

import com.sample.sampleedaspring.menu.domain.models.HotIced;
import lombok.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Value
public class DirectOrderItem {
    @Getter
    @NonNull
    private MenuId menuId;

    @NonNull
    private String menuName;

    @NonNull
    private HotIced hotIced;

    @NonNull
    @Positive
    private Integer orderCount;

    @NonNull
    @PositiveOrZero
    private BigDecimal price;

    public DirectOrderItem(
            @NonNull final MenuId menuId,
            @NonNull final String menuName,
            @NonNull final HotIced hotIced,
            @NonNull @Positive final Integer orderCount,
            @NonNull @PositiveOrZero final BigDecimal price) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.hotIced = hotIced;
        this.orderCount = orderCount;
        this.price = price;
    }
}
