package com.sample.sampleedaspring.user.infrastructure.repository.mysql;

import com.sample.sampleedaspring.user.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerMySQLRepositoryTest {

    @Autowired
    private CustomerMySQLRepository customerMySQLRepository;

    @Test
    @DisplayName("사용자 저장 테스트")
    void customer_login_success() {
        String loginId = "test_id";
        String loginPw = "test_pw";
        Customer customer = Customer.builder()
                .loginId(loginId)
                .loginPw(loginPw)
                .build();
        customerMySQLRepository.save(customer);

        Customer persistCustomer = customerMySQLRepository.findByIdAndPw(loginId, loginPw)
                .orElse(null);
        Assertions.assertNotNull(persistCustomer);
        Assertions.assertEquals(loginId, persistCustomer.getLoginId());
    }
}
