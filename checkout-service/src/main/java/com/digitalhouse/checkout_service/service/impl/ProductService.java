package com.digitalhouse.checkout_service.service.impl;

import com.digitalhouse.checkout_service.dto.ProductDto;
import com.digitalhouse.checkout_service.repository.IFeignProductRepository;
import com.digitalhouse.checkout_service.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final IFeignProductRepository productClient;

    public ProductService(IFeignProductRepository productClient) {
        this.productClient = productClient;
    }

    @Override
    public ProductDto getProduct(String id) {
        return productClient.getProductById(id);
    }
}
