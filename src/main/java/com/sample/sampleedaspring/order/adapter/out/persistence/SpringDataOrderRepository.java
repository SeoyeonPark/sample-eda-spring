package com.sample.sampleedaspring.order.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataOrderRepository extends JpaRepository<OrderJpaEntity, String> {
    Optional<OrderJpaEntity> findByCustomerId(String id);

}
