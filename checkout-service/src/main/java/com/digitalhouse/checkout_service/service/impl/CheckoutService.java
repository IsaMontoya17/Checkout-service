package com.digitalhouse.checkout_service.service.impl;

import com.digitalhouse.checkout_service.dto.ProductDto;
import com.digitalhouse.checkout_service.entity.Checkout;
import com.digitalhouse.checkout_service.service.ICheckoutService;
import com.digitalhouse.checkout_service.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService implements ICheckoutService{

    private IProductService productService;

    public CheckoutService(IProductService productService) {

        this.productService = productService;
    }

    @Override
    public Checkout buildCheckout(List<String> productIds) {
        Double total = 0.0;
        for(String id :  productIds){
            ProductDto product = productService.getProduct(id);
            total += product.getPrice();
        }
        Checkout checkout = new Checkout("234","www.digitalhouse.com/checkout?code=234",total.toString(),List.of("credit_card"));

        return checkout;
    }

}
