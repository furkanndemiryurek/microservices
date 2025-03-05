package com.furkandemiryurek.OrderService.controller;

import com.furkandemiryurek.OrderService.dto.OrderRequestDto;
import com.furkandemiryurek.OrderService.dto.OrderResponseDto;
import com.furkandemiryurek.OrderService.entity.Order;
import com.furkandemiryurek.OrderService.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        return new ResponseEntity<>(orderService.placeOrder(orderRequestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(orderService.findById(id));
    }


}
