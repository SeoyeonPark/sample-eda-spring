package com.sample.sampleedaspring.order.application.port.in;

import com.sample.sampleedaspring.order.domain.models.Order;

import java.util.List;

public interface GetOrderListQuery {
    List<Order> getAllCustomerOrderList();

    List<Order> getOrderList(final String customerId);
}
