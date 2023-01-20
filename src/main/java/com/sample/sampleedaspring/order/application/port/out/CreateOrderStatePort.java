package com.sample.sampleedaspring.order.application.port.out;

import com.sample.sampleedaspring.order.domain.models.Order;

public interface CreateOrderStatePort {
    void insertOrder(Order order);
}
