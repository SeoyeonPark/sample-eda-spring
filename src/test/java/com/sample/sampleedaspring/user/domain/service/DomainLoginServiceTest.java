package com.sample.sampleedaspring.user.domain.service;

import com.sample.sampleedaspring.user.domain.Customer;
import com.sample.sampleedaspring.user.domain.exception.DuplicatedLoginIdException;
import com.sample.sampleedaspring.user.domain.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DomainLoginServiceTest {

    private CustomerRepository customerRepository;
    private LoginService loginService;

    @BeforeEach
    void initialize() {
        customerRepository = mock(CustomerRepository.class);
        loginService = new DomainLoginService(customerRepository);
    }

//    @Test
//    void whenLoginWithExistedId_thenException() {
//        final String loginId = "existed_id";
//        when(customerRepository.findById(loginId)).thenReturn(Optional.of(
//                Customer.builder()
//                        .loginId(loginId)
//                        .build())
//        );
//
//        Assertions.assertThrows(DuplicatedLoginIdException.class, () -> loginService.login(loginId));
//    }

    @Test
    void whenLoginWithNewId_thenSaveCustomer() {
        final String loginId = "new_test_id";
        String responseLoginId = loginService.login(loginId);

        verify(customerRepository).save(any(Customer.class));
        Assertions.assertNotNull(responseLoginId);
        Assertions.assertEquals(loginId, responseLoginId);
    }
}
