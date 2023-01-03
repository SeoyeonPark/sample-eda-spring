package com.sample.sampleedaspring.order.domain.models.Order;

import com.sample.sampleedaspring.order.domain.models.Product.Product;
import com.sample.sampleedaspring.order.domain.models.Product.ProductId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter(AccessLevel.NONE)
public class OrderItem {
    private ProductId productId;
    private BigDecimal price;

    public OrderItem(final Product product) {
        this.productId = product.getId();
        this.price = product.getPrice();
    }
}
