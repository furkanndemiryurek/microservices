package com.furkandemiryurek.ProductService.mapper;

import com.furkandemiryurek.ProductService.dto.ProductRequestDto;
import com.furkandemiryurek.ProductService.dto.ProductResponseDto;
import com.furkandemiryurek.ProductService.entity.Product;

public class ProductMapper {

    public static ProductResponseDto productToDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setQuantity(product.getQuantity());

        return productResponseDto;
    }

    public static Product dtoToProduct(ProductRequestDto dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        return product;
    }

}
