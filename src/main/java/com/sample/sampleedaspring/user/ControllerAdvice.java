package com.sample.sampleedaspring.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.sampleedaspring.user.domain.exception.DuplicatedLoginIdException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            DuplicatedLoginIdException.class
    })
    public ResponseEntity<ErrorResponseBody> handleDomainException(RuntimeException ex) {
        return new ResponseEntity<>(ErrorResponseBody.builder().message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ErrorResponseBody {
        private String message;

        private String traceId;

        @Builder.Default
        @JsonProperty("occurred_date")
        private LocalDateTime occurDate = LocalDateTime.now();
    }
}
