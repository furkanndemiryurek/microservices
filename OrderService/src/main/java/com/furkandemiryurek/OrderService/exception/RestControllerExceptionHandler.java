package com.furkandemiryurek.OrderService.exception;

import com.furkandemiryurek.OrderService.external.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDto> customException(CustomException customException){
        return new ResponseEntity<>(new ErrorResponseDto(customException.getMessage())
                , HttpStatus.NOT_FOUND);
    }


}
