package com.furkandemiryurek.ProductService.exception;

import com.furkandemiryurek.ProductService.exception.exceptionDtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDto> productNotFoundExceptionResponseEntity(CustomException productNotFoundException){
        return new ResponseEntity<>(new ErrorResponseDto(productNotFoundException.getMessage())
                , HttpStatus.NOT_FOUND);
    }
}
