package com.digitalhouse.checkout_service.controller;

import com.digitalhouse.checkout_service.entity.Checkout;
import com.digitalhouse.checkout_service.service.ICheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutRestController {

    private final ICheckoutService checkoutService;

    public CheckoutRestController(ICheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("/{id}")
    public Checkout getById(@PathVariable String id) {
        return new Checkout(id);
    }

    @GetMapping
    public Checkout getCheckout(@RequestParam List<String> productIds, @RequestHeader("X-Request-from") String requestFrom, @RequestHeader()Map<String, String> headers) {
        System.out.println("Enviado desde "+ requestFrom);
        if(!requestFrom.equals("gateway")){
            return null;
        }
        return checkoutService.buildCheckout(productIds);
    }
}