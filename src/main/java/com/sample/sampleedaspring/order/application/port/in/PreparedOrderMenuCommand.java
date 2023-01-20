package com.sample.sampleedaspring.order.application.port.in;

import com.sample.sampleedaspring.order.domain.models.OrderId;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@EqualsAndHashCode(callSuper = false)
public class PreparedOrderMenuCommand {
    @NotNull
    private final OrderId orderId;
}
