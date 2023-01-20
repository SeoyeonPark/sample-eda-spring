package com.sample.sampleedaspring.order.application.service;

import com.sample.sampleedaspring.common.UseCase;
import com.sample.sampleedaspring.order.application.port.in.AddMenuToCartUseCase;
import com.sample.sampleedaspring.order.application.port.in.AddToCartCommand;

@UseCase
public class AddMenuToCartService implements AddMenuToCartUseCase {
    @Override
    public boolean addMenuToCart(AddToCartCommand command) {
        return false;
    }
}
