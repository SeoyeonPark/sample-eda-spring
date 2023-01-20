package com.sample.sampleedaspring.order.application.port.out;

import com.sample.sampleedaspring.order.domain.models.Order;
import com.sample.sampleedaspring.order.domain.models.OrderId;

import java.util.List;

public interface GetOrderListPort {
    List<Order> getAllOrderList();

    List<Order> getOrderListByCustomer(final String customerId);

    Order getOrderListByOrderId(final OrderId orderId);
}
