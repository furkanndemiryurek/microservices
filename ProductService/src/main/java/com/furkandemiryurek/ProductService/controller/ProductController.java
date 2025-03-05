package com.furkandemiryurek.ProductService.controller;

import com.furkandemiryurek.ProductService.dto.ProductRequestDto;
import com.furkandemiryurek.ProductService.dto.ProductResponseDto;
import com.furkandemiryurek.ProductService.entity.Product;
import com.furkandemiryurek.ProductService.service.ProductService;
import com.furkandemiryurek.ProductService.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto productDto){
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        return ResponseEntity.ok().body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId, @RequestParam Long quantity){
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
