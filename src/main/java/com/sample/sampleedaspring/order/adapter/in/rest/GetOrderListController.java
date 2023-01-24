package com.sample.sampleedaspring.order.adapter.in.rest;

import com.sample.sampleedaspring.order.application.port.in.GetOrderListQuery;
import com.sample.sampleedaspring.order.domain.models.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class GetOrderListController {
    private final GetOrderListQuery getOrderListQuery;

    @GetMapping(path = "/admin/barista")
    List<Order> getAllCustomerOrderList() {
        return getOrderListQuery.getAllCustomerOrderList();
    }

    @GetMapping(path = "/{loginId}")
    List<Order> getOrderList(@PathVariable("loginId") final String loginId) {
        log.info("Find order by login id: {}", loginId);
        return getOrderListQuery.getOrderList(loginId);
    }
}
