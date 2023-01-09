package com.sample.sampleedaspring.user.application.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.NONE)
@Getter
public class LoginResponse {
    private String id;
    private boolean result;
}
