package com.sample.sampleedaspring.order.adapter.out.persistence;

import com.sample.sampleedaspring.menu.domain.models.HotIced;
import com.sample.sampleedaspring.order.domain.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    List<OrderDetailJpaEntity> mapToDetailJpaEntity(List<DirectOrderItem> orderItemList) {
        List<OrderDetailJpaEntity> orderDetails = new ArrayList<>();
        for (DirectOrderItem orderItem : orderItemList) {
            orderDetails.add(OrderDetailJpaEntity.builder()
                    .menuId(orderItem.getMenuId().getValue())
                    .menuName(orderItem.getMenuName())
                    .hotIced(orderItem.getHotIced().name())
                    .orderCount(orderItem.getOrderCount())
                    .price(orderItem.getPrice())
                    .build());
        }

        return orderDetails;
    }

    OrderJpaEntity mapToJpaEntity(Order order) {
        List<OrderDetailJpaEntity> orderDetails = mapToDetailJpaEntity(order.getDirectOrderItems());

        return new OrderJpaEntity(
                null,
                order.getCustomerId(),
                order.getStatus().name(),
                order.getTotalPrice(),
                orderDetails
        );
    }

    Order mapToDomainEntity(OrderJpaEntity orderJpaEntity) {
        return new Order(
                new OrderId(orderJpaEntity.getOrderId()),
                orderJpaEntity.getCustomerId(),
                OrderStatus.valueOf(orderJpaEntity.getOrderStatus()),
                orderJpaEntity.getOrderDetails().stream()
                        .map(detail -> mapToDomainEntity(detail))
                        .collect(Collectors.toList()),
                orderJpaEntity.getCreatedAt()
        );
    }

    DirectOrderItem mapToDomainEntity(OrderDetailJpaEntity orderDetailJpaEntity) {
        return new DirectOrderItem(
                new MenuId(orderDetailJpaEntity.getMenuId()),
                orderDetailJpaEntity.getMenuName(),
                HotIced.valueOf(orderDetailJpaEntity.getHotIced()),
                orderDetailJpaEntity.getOrderCount(),
                orderDetailJpaEntity.getPrice()
        );
    }
}
