package com.sample.sampleedaspring.order.adapter.in.rest;

import com.sample.sampleedaspring.order.adapter.in.rest.request.AddToCartRequest;
import com.sample.sampleedaspring.order.application.port.in.AddMenuToCartUseCase;
import com.sample.sampleedaspring.order.application.port.in.AddToCartCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final AddMenuToCartUseCase addMenuToCartUseCase;

    @PostMapping
    void addToCart(@RequestBody AddToCartRequest request) {
        AddToCartCommand command = new AddToCartCommand(
                request.getLoginId(),
                request.getMenuId(),
                request.getHotIced(),
                request.getOrderCount(),
                request.getPricePerCup()
        );
        addMenuToCartUseCase.addMenuToCart(command);
    }

    @GetMapping
    void getCart() {

    }
}
