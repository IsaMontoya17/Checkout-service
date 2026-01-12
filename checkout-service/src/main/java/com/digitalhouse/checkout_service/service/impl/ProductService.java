package com.digitalhouse.checkout_service.service.impl;

import com.digitalhouse.checkout_service.dto.ProductDto;
import com.digitalhouse.checkout_service.repository.IFeignProductRepository;
import com.digitalhouse.checkout_service.service.IProductService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService  implements IProductService{

    private IFeignProductRepository feignProductRepository;

    Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(IFeignProductRepository feignProductRepository) {
        super();
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    @CircuitBreaker(name="product",fallbackMethod="getProductFallbackMethod")
    public ProductDto getProduct(String id) {
        return feignProductRepository.getProductById(id,true);
    }

    public ProductDto getProductFallbackMethod(String id, CallNotPermittedException exception ) {
        log.error("Circuit breaker en estado Open");

        return new ProductDto();
    }

}
