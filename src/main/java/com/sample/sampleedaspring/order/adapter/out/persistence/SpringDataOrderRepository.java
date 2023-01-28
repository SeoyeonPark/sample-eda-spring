package com.sample.sampleedaspring.order.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataOrderRepository extends JpaRepository<OrderJpaEntity, Long> {
    Optional<List<OrderJpaEntity>> findByCustomerId(String id);

}
