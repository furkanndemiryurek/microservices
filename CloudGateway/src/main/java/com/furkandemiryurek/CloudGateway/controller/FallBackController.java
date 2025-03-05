package com.furkandemiryurek.CloudGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBack() {
        return "Product Service is Down";
    }

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallBack() {
        return "Order Service is Down";
    }

    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallBack() {
        return "Payment Service is Down";
    }

    @GetMapping("/mailServiceFallBack")
    public String mailServiceFallBack() {
        return "Mail Service is Down";
    }
}
