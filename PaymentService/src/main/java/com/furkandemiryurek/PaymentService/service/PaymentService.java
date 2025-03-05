package com.furkandemiryurek.PaymentService.service;

import com.furkandemiryurek.PaymentService.dto.PaymentRequest;
import com.furkandemiryurek.PaymentService.dto.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse findPaymentDetailsByOrderId(Long orderId);
}
