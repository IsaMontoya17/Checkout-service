package com.digitalhouse.checkout_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {
    private String id;
    private String url;
    private String totalAmount;
    private List<String> availableMethods;

    public Checkout(String id) {
        this.id = id;
    }
}