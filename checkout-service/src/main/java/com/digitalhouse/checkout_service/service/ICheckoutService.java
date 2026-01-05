package com.digitalhouse.checkout_service.service;

import com.digitalhouse.checkout_service.entity.Checkout;

import java.util.List;

public interface ICheckoutService {
    public Checkout buildCheckout(List<String> productsIds);
}
