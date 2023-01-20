package com.sample.sampleedaspring.order.adapter.out.persistence;

import com.sample.sampleedaspring.common.PersistenceAdapter;
import com.sample.sampleedaspring.order.application.port.out.CreateOrderStatePort;
import com.sample.sampleedaspring.order.application.port.out.GetOrderListPort;
import com.sample.sampleedaspring.order.application.port.out.PreparedOrderMenuPort;
import com.sample.sampleedaspring.order.domain.models.Order;
import com.sample.sampleedaspring.order.domain.models.OrderId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Slf4j
public class OrderPersistenceAdapter implements
        CreateOrderStatePort,
        GetOrderListPort,
        PreparedOrderMenuPort {

    private final SpringDataOrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public void insertOrder(Order order) {
        OrderJpaEntity orderJpaEntity = orderMapper.mapToJpaEntity(order);
        orderRepository.save(orderJpaEntity);
    }

    @Override
    public List<Order> getAllOrderList() {
        return orderRepository.findAll().stream()
                .map(orderJpaEntity -> orderMapper.mapToDomainEntity(orderJpaEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrderListByCustomer(String customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(orderJpaEntity -> orderMapper.mapToDomainEntity(orderJpaEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Order getOrderListByOrderId(OrderId orderId) {
        String id = orderId.getValue();
        OrderJpaEntity orderJpaEntity = orderRepository.findById(id)
                .orElse(new OrderJpaEntity());
        return orderMapper.mapToDomainEntity(orderJpaEntity);
    }

    @Override
    public void completeOrderStatus(Order order) {
        OrderJpaEntity orderJpaEntity = orderMapper.mapToJpaEntity(order);
        orderRepository.save(orderJpaEntity);
    }
}
