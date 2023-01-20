package com.sample.sampleedaspring.order.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "coffee_order_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class OrderDetailJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_order_id"))
    private OrderJpaEntity orderId;

    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "hot_iced")
    private String hotIced;

    @Column(name = "cup_size")
    private String cup;

    @Column(name = "order_ount")
    private Integer orderCount;

    @Column(name = "price")
    private BigDecimal price;
}
