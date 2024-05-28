package com.example.WebFluxTest.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="DDD Not Found")
public class DDDNotFoundException extends Exception{

    public DDDNotFoundException(){
        super("DDD Não encontrado");
    }

}
