package com.digitalhouse.checkout_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private Double price;

    public ProductDto() {
        this.id = "unknown";
        this.name = "Unknown Product";
        this.price = 0.0;
    }
}

