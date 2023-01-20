package com.sample.sampleedaspring.order.application.port.in;

public interface CreateDirectOrderUseCase {
    boolean createOrder(CreateDirectOrderCommand command);
}
