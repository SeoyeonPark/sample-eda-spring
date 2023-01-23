package com.sample.sampleedaspring.user.domain.repository;

import com.sample.sampleedaspring.user.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findByIdAndPw(String id, String pw);

    void save(Customer customer);
}
