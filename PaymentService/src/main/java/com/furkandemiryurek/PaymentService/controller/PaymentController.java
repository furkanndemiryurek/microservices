package com.furkandemiryurek.PaymentService.controller;


import com.furkandemiryurek.PaymentService.dto.PaymentRequest;
import com.furkandemiryurek.PaymentService.dto.PaymentResponse;
import com.furkandemiryurek.PaymentService.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentServiceImpl detailsService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.ok().body(detailsService.doPayment(paymentRequest));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentResponse> findPaymentDetailsByOrderId(@PathVariable("orderId") Long orderId){
        return ResponseEntity.ok().body(detailsService.findPaymentDetailsByOrderId(orderId));
    }


}
