package com.furkandemiryurek.PaymentService.service;

import com.furkandemiryurek.PaymentService.dto.PaymentRequest;
import com.furkandemiryurek.PaymentService.dto.PaymentResponse;
import com.furkandemiryurek.PaymentService.entity.TransactionDetails;
import com.furkandemiryurek.PaymentService.exception.CustomException;
import com.furkandemiryurek.PaymentService.mapper.PaymentMapper;
import com.furkandemiryurek.PaymentService.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository repository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        TransactionDetails transactionDetails = PaymentMapper.dtoToDetails(paymentRequest);
        transactionDetails.setPaymentDate(LocalDate.now());
        transactionDetails = repository.save(transactionDetails);
        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse findPaymentDetailsByOrderId(Long orderId) {
        TransactionDetails transactionDetails = repository.findByOrderId(orderId).orElseThrow(
                () -> new CustomException("Payment Not Found With Id : " + orderId));
        return PaymentMapper.detailsToDto(transactionDetails);
    }


}
