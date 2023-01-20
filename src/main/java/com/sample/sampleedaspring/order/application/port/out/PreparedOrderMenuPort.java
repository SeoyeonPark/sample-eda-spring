package com.sample.sampleedaspring.order.application.port.out;

import com.sample.sampleedaspring.order.domain.models.Order;

public interface PreparedOrderMenuPort {
    void completeOrderStatus(Order order);
}
