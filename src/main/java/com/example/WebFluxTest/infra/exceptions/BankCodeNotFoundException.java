package com.example.WebFluxTest.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Bank Code Not Found")
public class BankCodeNotFoundException extends Exception{

    public BankCodeNotFoundException(){
        super("Código bancário não encontrado");
    }

}
