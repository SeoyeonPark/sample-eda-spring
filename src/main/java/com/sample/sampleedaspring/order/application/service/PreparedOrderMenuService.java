package com.sample.sampleedaspring.order.application.service;

import com.sample.sampleedaspring.common.UseCase;
import com.sample.sampleedaspring.order.application.port.in.PreparedOrderMenuCommand;
import com.sample.sampleedaspring.order.application.port.in.PreparedOrderMenuUseCase;
import com.sample.sampleedaspring.order.application.port.out.GetOrderListPort;
import com.sample.sampleedaspring.order.application.port.out.PreparedOrderMenuPort;
import com.sample.sampleedaspring.order.domain.models.Order;
import com.sample.sampleedaspring.order.domain.models.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class PreparedOrderMenuService implements PreparedOrderMenuUseCase {

    private final GetOrderListPort getOrderListPort;
    private final PreparedOrderMenuPort preparedOrderMenuPort;

    @Override
    public void completeOrderMenu(PreparedOrderMenuCommand command) {
        OrderId orderId = command.getOrderId();
        Order order = getOrderListPort.getOrderListByOrderId(orderId);
        order.completeOrder();

        preparedOrderMenuPort.completeOrderStatus(order);
    }
}
