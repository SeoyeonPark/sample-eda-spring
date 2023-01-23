package com.sample.sampleedaspring.user.infrastructure.repository.mysql;

import com.sample.sampleedaspring.user.domain.Customer;
import com.sample.sampleedaspring.user.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
@RequiredArgsConstructor
public class CustomerMySQLRepository implements CustomerRepository {

    private final SpringDataCustomerMySQLRepository repository;

    @Override
    public Optional<Customer> findByIdAndPw(final String id, final String pw) {
        return repository.findByLoginIdAndLoginPw(id, pw);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }
}
