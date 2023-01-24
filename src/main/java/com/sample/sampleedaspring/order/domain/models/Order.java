package com.sample.sampleedaspring.order.domain.models;

import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    @Getter
    private final OrderId id;
    @Getter
    @NonNull
    private final String customerId;
    @Getter
    @NonNull
    private OrderStatus status;
    @Getter
    @NonNull
    @Size(min = 1, max = 20)
    private List<DirectOrderItem> directOrderItems;
    @Getter
    @NonNull
    private BigDecimal totalPrice;
    @Getter
    private LocalDateTime orderedAt;

    public Order(
            @NonNull OrderId id,
            @NonNull String customerId,
            @NonNull OrderStatus status,
            @NonNull @Size(min = 1, max = 20) List<DirectOrderItem> directOrderItems,
            LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.directOrderItems = new ArrayList<>(directOrderItems);
        this.status = status;
        this.totalPrice = directOrderItems.stream()
                .map(o -> o.getPrice())
                .reduce(new BigDecimal(0), (a, b) -> a.add(b));
        this.orderedAt = createdAt;
    }

    private void validateOrderState() {
        if (OrderStatus.COMPLETED.equals(status)) {
            throw new DomainException("이미 완료된 주문 건입니다");
        }
    }

    public void completeOrder() {
        validateOrderState();

        status = OrderStatus.COMPLETED;
    }

    public void addOrder(final DirectOrderItem directOrderItem) {
        validateOrderState();

        directOrderItems.add(directOrderItem);
        totalPrice.add(directOrderItem.getPrice());
    }

    public void removeOrder(final OrderId id) {
        validateOrderState();
        final DirectOrderItem directOrderItem = directOrderItems.stream()
                .filter(existItem -> existItem.getMenuId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DomainException("Menu id " + id + " does not exist."));
        directOrderItems.remove(directOrderItem);
        totalPrice.subtract(directOrderItem.getPrice());
    }

}
