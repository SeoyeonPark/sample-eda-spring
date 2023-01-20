package com.sample.sampleedaspring.order.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderDetailRepository extends JpaRepository<OrderDetailJpaEntity, String> {
}
