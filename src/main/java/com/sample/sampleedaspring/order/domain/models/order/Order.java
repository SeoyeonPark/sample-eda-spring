package com.sample.sampleedaspring.order.domain.models.order;

import com.sample.sampleedaspring.order.domain.models.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter(AccessLevel.NONE)
public class Order {
    private OrderId id;
    private OrderStatus status;
    private List<OrderItem> orderItems;
    private BigDecimal price;

    public Order(OrderId id, Product product) {
        this.id = id;
        this.orderItems = new ArrayList<>(Arrays.asList(new OrderItem(product)));
        this.status = OrderStatus.CREATED;
        this.price = new BigDecimal(0);
    }

    public void validateOrderState() {
        if (OrderStatus.COMPLETED.equals(status)) {
            throw new DomainException("이미 완료된 주문 건입니다");
        }
    }

    public void validateProduct(Product product) {
        if (product == null) {
            throw new DomainException("The product cannot be null");
        }
    }

    public void addOrder(final Product product) {
        validateOrderState();
        validateProduct(product);

        orderItems.add(new OrderItem(product));
        price = price.add(product.getPrice());
    }

    public void removeOrder(final OrderId id) {
        validateOrderState();
        final OrderItem orderItem = orderItems.stream()
                .filter(existItem -> existItem.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DomainException("Product id " + id + " does not exist."));
        orderItems.remove(orderItem);
        price = price.subtract(orderItem.getPrice());
    }

}
