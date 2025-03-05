package com.furkandemiryurek.OrderService.mapper;

import com.furkandemiryurek.OrderService.dto.OrderRequestDto;
import com.furkandemiryurek.OrderService.dto.OrderResponseDto;
import com.furkandemiryurek.OrderService.entity.Order;

public class OrderMapper {

    public static Order dtoToOrder(OrderRequestDto orderRequestDto){
        Order order = new Order();
        order.setProductId(orderRequestDto.getProductId());
        order.setQuantity(orderRequestDto.getQuantity());
        order.setAmount(orderRequestDto.getTotalAmount());
        return order;
    }

    public static OrderResponseDto orderToDto(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setProductId(order.getProductId());
        orderResponseDto.setTotalAmount(order.getAmount());
        orderResponseDto.setQuantity(order.getAmount());
        return orderResponseDto;
    }
}
