package com.sample.sampleedaspring.order.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "coffee_order")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
class OrderJpaEntity extends BaseEntity {
    @Id
    @Column(name = "order_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "customer_id", updatable = false)
    private String customerId;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_order_detail_id"))
    private List<OrderDetailJpaEntity> orderDetails = new ArrayList<>();
}
