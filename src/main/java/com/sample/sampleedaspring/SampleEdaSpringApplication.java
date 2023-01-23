package com.sample.sampleedaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SampleEdaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleEdaSpringApplication.class, args);
    }

}
