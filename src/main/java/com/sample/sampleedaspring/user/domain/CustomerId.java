package com.sample.sampleedaspring.user.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CustomerId implements Serializable {
    private String loginId;

    private String loginPw;
}