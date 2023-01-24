package com.sample.sampleedaspring.order.application.service;

import com.sample.sampleedaspring.order.application.port.in.GetOrderListQuery;
import com.sample.sampleedaspring.order.application.port.out.GetOrderListPort;
import com.sample.sampleedaspring.order.domain.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetOrderListService implements GetOrderListQuery {

    private final GetOrderListPort getOrderListPort;

    @Override
    public List<Order> getAllCustomerOrderList() {
        return getOrderListPort.getAllOrderList().stream()
                .sorted((o1, o2) ->
                        o1.getStatus().equals(o2.getStatus())
                        ? o1.getOrderedAt().compareTo(o2.getOrderedAt())
                        : o1.getStatus().compareTo(o2.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrderList(String customerId) {
        return getOrderListPort.getOrderListByCustomer(customerId);
    }
}
