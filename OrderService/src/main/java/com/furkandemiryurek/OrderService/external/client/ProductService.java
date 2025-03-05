package com.furkandemiryurek.OrderService.external.client;

import com.furkandemiryurek.OrderService.exception.CustomException;
import com.furkandemiryurek.OrderService.external.response.ProductResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CircuitBreaker(name = "external", fallbackMethod = "fallBack")
@FeignClient(name = "PRODUCT-SERVICE/product")
public interface ProductService {

    @PutMapping("/reduceQuantity/{id}")
    ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId, @RequestParam Long quantity);

    @GetMapping("/{id}")
    ResponseEntity<ProductResponseDto> findById(@PathVariable("id") Long id);

    default void fallBack(Exception e){
        throw new CustomException("Payment service is down");
    }
}
