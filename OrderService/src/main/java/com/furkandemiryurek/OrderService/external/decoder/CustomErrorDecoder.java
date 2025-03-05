package com.furkandemiryurek.OrderService.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.furkandemiryurek.OrderService.exception.CustomException;
import com.furkandemiryurek.OrderService.external.response.ErrorResponseDto;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ErrorResponseDto errorResponseDto = objectMapper.readValue(response.body().asInputStream(), ErrorResponseDto.class);

            return new CustomException(errorResponseDto.getErrorMessage());
        } catch (IOException e) {
            throw new CustomException(e.getMessage());
        }
    }
}
