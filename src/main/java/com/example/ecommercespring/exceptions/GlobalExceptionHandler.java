package com.example.ecommercespring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> productNotFound(ProductNotFoundException p){

        ErrorResponse error=new ErrorResponse(HttpStatus.NO_CONTENT.value(), p.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> categoryNotFound(CategoryNotFoundException category){
        ErrorResponse error=new ErrorResponse(HttpStatus.NO_CONTENT.value(), category.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
