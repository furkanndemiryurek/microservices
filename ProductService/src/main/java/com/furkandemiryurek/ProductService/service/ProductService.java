package com.furkandemiryurek.ProductService.service;

import com.furkandemiryurek.ProductService.dto.ProductRequestDto;
import com.furkandemiryurek.ProductService.dto.ProductResponseDto;
import com.furkandemiryurek.ProductService.entity.Product;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductResponseDto addProduct(ProductRequestDto productDto);

    List<ProductResponseDto> getAll();

    void reduceQuantity(Long productId, Long quantity);

    ProductResponseDto findById(Long orderId);
}
