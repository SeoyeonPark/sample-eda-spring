package com.sample.sampleedaspring.order.adapter.in.rest;

import com.sample.sampleedaspring.order.adapter.in.rest.request.CreateDirectOrderRequest;
import com.sample.sampleedaspring.order.application.port.in.CreateDirectOrderCommand;
import com.sample.sampleedaspring.order.application.port.in.CreateDirectOrderUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class CreateDirectOrderController {

    private final CreateDirectOrderUseCase createDirectOrderUseCase;

    @PostMapping
    boolean orderMenu(@RequestBody CreateDirectOrderRequest request) {
        log.info(request.toString());
        CreateDirectOrderCommand command = new CreateDirectOrderCommand(
                request.getLoginId(),
                request.getMenuId(),
                request.getMenuName(),
                request.getHotIced(),
                request.getOrderCount(),
                request.getPrice()
        );
        return createDirectOrderUseCase.createOrder(command);
    }
}
