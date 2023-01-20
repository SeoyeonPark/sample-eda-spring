package com.sample.sampleedaspring.user.application.rest;

import com.sample.sampleedaspring.user.application.request.LoginRequest;
import com.sample.sampleedaspring.user.application.response.LoginResponse;
import com.sample.sampleedaspring.user.domain.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        log.info("Login user: {}", request.getId());
        String loginId = loginService.login(request.getId());
        LoginResponse response = LoginResponse.builder()
                .id(loginId)
                .build();
        return response;
    }
}
