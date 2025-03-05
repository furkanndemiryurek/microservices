package com.furkandemiryurek.ProductService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class ProductResponseDto {
    @JsonIgnore
    private Long id;
    private String name;
    private BigDecimal price;
    private Long quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
