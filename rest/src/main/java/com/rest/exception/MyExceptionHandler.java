package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ClientException> exceptionResponseEntity(MyException myException){
        ClientException exception = new ClientException(HttpStatus.NOT_FOUND.value(),myException.getMessage());
        return  new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }
}
