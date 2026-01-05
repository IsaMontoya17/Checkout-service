package com.digitalhouse.checkout_service.service;

import com.digitalhouse.checkout_service.dto.ProductDto;

public interface IProductService {
    ProductDto getProduct(String id);
}
