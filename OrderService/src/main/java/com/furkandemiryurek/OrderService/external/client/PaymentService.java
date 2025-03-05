package com.furkandemiryurek.OrderService.external.client;

import com.furkandemiryurek.OrderService.exception.CustomException;
import com.furkandemiryurek.OrderService.external.response.PaymentRequest;
import com.furkandemiryurek.OrderService.external.response.PaymentResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CircuitBreaker(name = "external", fallbackMethod = "fallBack")
@FeignClient("PAYMENT-SERVICE/payment")
public interface PaymentService {

    @PostMapping
    ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

    @GetMapping("/{orderId}")
    ResponseEntity<PaymentResponse> findPaymentDetailsByOrderId(@PathVariable("orderId") Long orderId);

    default void fallBack(Exception e){
        throw new CustomException("Payment service is down");
    }
}
