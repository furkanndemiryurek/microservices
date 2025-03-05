package com.furkandemiryurek.PaymentService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private Long orderId;
    private String referenceNumber;
    private Long amount;
    private LocalDate paymentDate;
}
