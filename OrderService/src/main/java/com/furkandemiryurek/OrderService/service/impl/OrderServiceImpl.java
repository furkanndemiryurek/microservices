package com.furkandemiryurek.OrderService.service.impl;

import com.furkandemiryurek.OrderService.dto.OrderRequestDto;
import com.furkandemiryurek.OrderService.dto.OrderResponseDto;
import com.furkandemiryurek.OrderService.entity.Order;
import com.furkandemiryurek.OrderService.exception.CustomException;
import com.furkandemiryurek.OrderService.external.client.PaymentService;
import com.furkandemiryurek.OrderService.external.client.ProductService;
import com.furkandemiryurek.OrderService.external.response.PaymentRequest;
import com.furkandemiryurek.OrderService.external.response.PaymentResponse;
import com.furkandemiryurek.OrderService.external.response.ProductResponseDto;
import com.furkandemiryurek.OrderService.mapper.OrderMapper;
import com.furkandemiryurek.OrderService.repository.OrderRepository;
import com.furkandemiryurek.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    private static final String userMail = "demiryureekk@gmail.com";

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Autowired
    PaymentService paymentService;

    private final KafkaTemplate<String, Object> kaftaTemplate;

    public OrderServiceImpl(KafkaTemplate<String, Object> kaftaTemplate) {
        this.kaftaTemplate = kaftaTemplate;
    }

    @Override
    public Long placeOrder(OrderRequestDto orderRequestDto) {

        productService.reduceQuantity(orderRequestDto.getProductId(), orderRequestDto.getQuantity());

        Order order = OrderMapper.dtoToOrder(orderRequestDto);
        order.setOrderDate(LocalDate.now());
        order.setOrderStatus("TEST");
        order = orderRepository.save(order);

        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setOrderId(order.getId());
        paymentRequest.setAmount(order.getAmount());
        paymentRequest.setReferenceNumber(new Random().nextInt(10000) + "");
        paymentService.doPayment(paymentRequest);

        sendKafkaMessage(userMail);

        return order.getId();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderResponseDto findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException("Order not found. ID : "+ id));
        OrderResponseDto orderResponseDto = OrderMapper.orderToDto(order);

        ProductResponseDto productResponse = productService.findById(order.getProductId()).getBody();
        PaymentResponse paymentResponse = paymentService.findPaymentDetailsByOrderId(id).getBody();

        orderResponseDto.setProductResponse(productResponse);
        orderResponseDto.setPaymentResponse(paymentResponse);

        return orderResponseDto;
    }

    private void sendKafkaMessage(String message) {
        kaftaTemplate.send("furkan", message);
    }
}
