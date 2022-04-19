package com.audaz.audaz.exception;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidFareException.class)
    public ResponseEntity<String> invalidFareHandler(InvalidFareException invalidFareException){

        return new ResponseEntity<>("Fare invalid, try again.", HttpStatus.BAD_REQUEST);
    }

}
