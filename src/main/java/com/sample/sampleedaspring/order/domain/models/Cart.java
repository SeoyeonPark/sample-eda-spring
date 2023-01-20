package com.sample.sampleedaspring.order.domain.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Value
public class Cart {
    @Getter
    @NonNull
    private String customerId;

    @Getter
    @NonNull
    private List<CartOrderItem> orderItems;

    @Getter
    @NonNull
    @PositiveOrZero
    private BigDecimal totalPrice;


    public Cart(
            @NonNull final String customerId,
            @NonNull @Size(min = 0, max = 20) List<CartOrderItem> orderItems
            ) {
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.totalPrice = orderItems.stream()
                .map(o -> o.getPrice())
                .reduce(new BigDecimal(0), (a, b) -> a.add(b));
    }

}