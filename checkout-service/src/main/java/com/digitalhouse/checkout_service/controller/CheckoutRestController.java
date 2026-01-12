package com.digitalhouse.checkout_service.controller;

import com.digitalhouse.checkout_service.entity.Checkout;
import com.digitalhouse.checkout_service.service.ICheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/checkout")
public class CheckoutRestController {
    private ICheckoutService checkoutService;

    public CheckoutRestController(ICheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }

    @GetMapping("/{id}")
    public Checkout getById(@PathVariable String id) {
        return new Checkout(id);
    }


    @GetMapping()
    public Checkout getCheckout(@RequestParam List<String> productIds,
                                @RequestHeader("X-Request-from") List<String> requestFromValues) {

        System.out.println("Valores del header X-Request-from: " + requestFromValues);

        boolean fromGateway = requestFromValues.stream()
                .anyMatch(value -> value.trim().equals("gateway"));

        if (!fromGateway) {
            return Checkout.builder()
                    .id("error")
                    .url("Request must come from gateway")
                    .totalAmount("0.0")
                    .availableMethods(List.of())
                    .build();
        }

        return checkoutService.buildCheckout(productIds);
    }
}