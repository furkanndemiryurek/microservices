package com.furkandemiryurek.OrderService.service;

import com.furkandemiryurek.OrderService.dto.OrderRequestDto;
import com.furkandemiryurek.OrderService.dto.OrderResponseDto;
import com.furkandemiryurek.OrderService.entity.Order;

import java.util.List;

public interface OrderService {
    Long placeOrder(OrderRequestDto orderRequestDto);

    List<Order> findAll();

    OrderResponseDto findById(Long id);
}
