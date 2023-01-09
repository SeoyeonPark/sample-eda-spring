package com.sample.sampleedaspring.user.infrastructure.repository.mysql;

import com.sample.sampleedaspring.user.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCustomerMySQLRepository extends JpaRepository<Customer, String> {
}
