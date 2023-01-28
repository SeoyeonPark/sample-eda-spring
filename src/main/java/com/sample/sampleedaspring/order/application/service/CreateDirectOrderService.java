package com.sample.sampleedaspring.order.application.service;

import com.sample.sampleedaspring.common.UseCase;
import com.sample.sampleedaspring.order.application.port.in.CreateDirectOrderCommand;
import com.sample.sampleedaspring.order.application.port.in.CreateDirectOrderUseCase;
import com.sample.sampleedaspring.order.application.port.out.CreateOrderStatePort;
import com.sample.sampleedaspring.order.domain.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CreateDirectOrderService implements CreateDirectOrderUseCase {

    private final CreateOrderStatePort createOrderStatePort;

    @Override
    public boolean createOrder(CreateDirectOrderCommand command) {
        BigDecimal totalPrice = new BigDecimal(command.getPricePerCup() * command.getNumber());

        // TODO 재고 체크

        DirectOrderItem directOrderItem = new DirectOrderItem(
                new MenuId(command.getMenuId()),
                command.getMenuName(),
                command.getHotIced(),
                command.getNumber(),
                totalPrice);
        log.info(directOrderItem.toString());

        Order order = new Order(
                new OrderId(null),
                command.getCustomerId(),
                OrderStatus.CREATED,
                List.of(directOrderItem),
                null
        );

        createOrderStatePort.insertOrder(order);
        return true;
    }
}
