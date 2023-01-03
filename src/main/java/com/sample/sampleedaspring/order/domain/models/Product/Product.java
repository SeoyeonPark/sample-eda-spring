package com.sample.sampleedaspring.order.domain.models.Product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter(AccessLevel.NONE)
public class Product {
    private final ProductId id;
    private final BigDecimal price;
    private final String name;

    public Product(final ProductId id, final BigDecimal price, final String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
}
