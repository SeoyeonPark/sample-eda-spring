package com.sample.sampleedaspring.user.domain.service;

import com.sample.sampleedaspring.user.domain.exception.DuplicatedLoginIdException;

public interface LoginService {
    String login(String id) throws DuplicatedLoginIdException;
}
