package com.furkandemiryurek.PaymentService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> customException(PaymentNotFoundException customException){
        return new ResponseEntity<>(new ErrorResponseDto(customException.getMessage())
                , HttpStatus.NOT_FOUND);
    }


}
