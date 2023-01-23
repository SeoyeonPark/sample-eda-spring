package com.sample.sampleedaspring.order.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "coffee_order_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class OrderDetailJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_order_id"))
    private OrderJpaEntity orderId;

    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "hot_iced")
    private String hotIced;

    @Column(name = "order_ount")
    private Integer orderCount;

    @Column(name = "price")
    private BigDecimal price;
}
