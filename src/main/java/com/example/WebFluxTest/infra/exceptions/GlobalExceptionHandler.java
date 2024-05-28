package com.example.WebFluxTest.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BankCodeNotFoundException.class)
    public ResponseEntity<String> handleBankCodeNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message: " + ex.getMessage() + "\n" + "Type: " + ex.getClass() );
    }

}
