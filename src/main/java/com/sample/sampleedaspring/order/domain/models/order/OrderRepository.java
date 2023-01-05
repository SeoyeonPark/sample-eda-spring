package com.sample.sampleedaspring.order.domain.models.order;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(OrderId id);

    void save(Order order);
}
