package com.sample.sampleedaspring.order.adapter.in.rest;

import com.sample.sampleedaspring.order.adapter.in.rest.request.PreparedOrderMenuRequest;
import com.sample.sampleedaspring.order.application.port.in.PreparedOrderMenuCommand;
import com.sample.sampleedaspring.order.application.port.in.PreparedOrderMenuUseCase;
import com.sample.sampleedaspring.order.domain.models.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PreparedOrderMenuController {

    private final PreparedOrderMenuUseCase preparedOrderMenuUseCase;

    @PostMapping(path = "/prepared")
    void preparedOrderMenu(@RequestBody PreparedOrderMenuRequest request) {
        PreparedOrderMenuCommand command = new PreparedOrderMenuCommand(
                new OrderId(request.getOrderId())
        );
        preparedOrderMenuUseCase.completeOrderMenu(command);
    }
}
