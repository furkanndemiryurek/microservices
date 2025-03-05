package com.furkandemiryurek.ProductService.service.impl;

import com.furkandemiryurek.ProductService.dto.ProductRequestDto;
import com.furkandemiryurek.ProductService.dto.ProductResponseDto;
import com.furkandemiryurek.ProductService.entity.Product;
import com.furkandemiryurek.ProductService.exception.CustomException;
import com.furkandemiryurek.ProductService.mapper.ProductMapper;
import com.furkandemiryurek.ProductService.repository.ProductRepository;
import com.furkandemiryurek.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productDto) {
        Product product = ProductMapper.dtoToProduct(productDto);
        product = productRepository.save(product);
        return ProductMapper.productToDto(product);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream().map(ProductMapper::productToDto).toList();
    }

    @Override
    public void reduceQuantity(Long productId, Long quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CustomException("Product not found with the given ID : " + productId));

        if (product.getQuantity() < quantity) throw new CustomException("The requested quantity is not available in stock.");

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Product not found with the given ID : " + id));
        return ProductMapper.productToDto(product);
    }
}
