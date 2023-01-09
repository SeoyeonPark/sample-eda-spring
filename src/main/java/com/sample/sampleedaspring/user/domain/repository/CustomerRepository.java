package com.sample.sampleedaspring.user.domain.repository;

import com.sample.sampleedaspring.user.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(String id);

    void save(Customer customer);
}
