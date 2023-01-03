package com.sample.sampleedaspring.order.domain.models.Product;

import lombok.AccessLevel;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Setter(AccessLevel.NONE)
public class ProductId {
    private String id;

    public ProductId(String category, String id) {
        this.id = LocalDate.now().format(DateTimeFormatter.ISO_DATE) + "_" + category + "_" + id;
    }
}
