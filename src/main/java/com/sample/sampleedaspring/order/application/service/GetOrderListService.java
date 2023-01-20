package com.sample.sampleedaspring.order.application.service;

import com.sample.sampleedaspring.order.application.port.in.GetOrderListQuery;
import com.sample.sampleedaspring.order.application.port.out.GetOrderListPort;
import com.sample.sampleedaspring.order.domain.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetOrderListService implements GetOrderListQuery {

    private final GetOrderListPort getOrderListPort;

    @Override
    public List<Order> getAllCustomerOrderList() {
        return getOrderListPort.getAllOrderList();
    }

    @Override
    public List<Order> getOrderList(String customerId) {
        return getOrderListPort.getOrderListByCustomer(customerId);
    }
}
