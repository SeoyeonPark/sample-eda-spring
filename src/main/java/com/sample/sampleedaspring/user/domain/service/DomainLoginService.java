package com.sample.sampleedaspring.user.domain.service;

import com.sample.sampleedaspring.user.domain.Customer;
import com.sample.sampleedaspring.user.domain.exception.DuplicatedLoginIdException;
import com.sample.sampleedaspring.user.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DomainLoginService implements LoginService {

    private final CustomerRepository customerRepository;

    @Override
    public String login(String id, String pw) throws DuplicatedLoginIdException {
        Customer customer = customerRepository.findByIdAndPw(id, pw)
                .orElse(Customer.builder()
                        .loginId(id)
                        .build());
        customerRepository.save(customer);
        return id;
    }
}
