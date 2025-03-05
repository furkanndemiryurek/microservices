package com.furkandemiryurek.PaymentService.mapper;

import com.furkandemiryurek.PaymentService.dto.PaymentRequest;
import com.furkandemiryurek.PaymentService.dto.PaymentResponse;
import com.furkandemiryurek.PaymentService.entity.TransactionDetails;

public class PaymentMapper {

    public static TransactionDetails dtoToDetails(PaymentRequest paymentRequest){
        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setAmount(paymentRequest.getAmount());
        transactionDetails.setOrderId(paymentRequest.getOrderId());
        transactionDetails.setReferenceNumber(paymentRequest.getReferenceNumber());

        return transactionDetails;
    }

    public static PaymentResponse detailsToDto(TransactionDetails details){
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setOrderId(details.getOrderId());
        paymentResponse.setAmount(details.getAmount());
        paymentResponse.setReferenceNumber(details.getReferenceNumber());
        paymentResponse.setPaymentDate(details.getPaymentDate());
        return paymentResponse;
    }
}
