package com.furkandemiryurek.OrderService.dto;

import com.furkandemiryurek.OrderService.external.response.PaymentResponse;
import com.furkandemiryurek.OrderService.external.response.ProductResponseDto;

public class OrderResponseDto {

    private Long productId;
    private Long totalAmount;
    private Long quantity;
    private PaymentResponse paymentResponse;
    private ProductResponseDto productResponse;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    public void setPaymentResponse(PaymentResponse paymentResponse) {
        this.paymentResponse = paymentResponse;
    }

    public ProductResponseDto getProductResponse() {
        return productResponse;
    }

    public void setProductResponse(ProductResponseDto productResponse) {
        this.productResponse = productResponse;
    }
}
