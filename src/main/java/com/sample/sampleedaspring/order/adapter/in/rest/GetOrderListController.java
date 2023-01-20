package com.sample.sampleedaspring.order.adapter.in.rest;

import com.sample.sampleedaspring.order.application.port.in.GetOrderListQuery;
import com.sample.sampleedaspring.order.domain.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GetOrderListController {
    private final GetOrderListQuery getOrderListQuery;

    @GetMapping(path = "/barista")
    List<Order> getAllCustomerOrderList() {
        return getOrderListQuery.getAllCustomerOrderList();
    }

    @GetMapping(path = "/{loginId}")
    List<Order> getOrderList(@PathVariable("loginId") final String loginId) {
        return getOrderListQuery.getOrderList(loginId);
    }
}
