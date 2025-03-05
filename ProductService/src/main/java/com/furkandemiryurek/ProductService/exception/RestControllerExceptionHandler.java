package com.furkandemiryurek.ProductService.exception;

import com.furkandemiryurek.ProductService.exception.exceptionDtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> productNotFoundExceptionResponseEntity(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(new ErrorResponseDto(productNotFoundException.getMessage())
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ErrorResponseDto> insufficientStockExceptionResponseEntity(InsufficientStockException insufficientStockException){
        return new ResponseEntity<>(new ErrorResponseDto(insufficientStockException.getMessage())
                , HttpStatus.NOT_FOUND);
    }

}
