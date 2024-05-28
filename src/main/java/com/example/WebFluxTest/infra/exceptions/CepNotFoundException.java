package com.example.WebFluxTest.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Cep Not Found In The Database")
public class CepNotFoundException extends Exception{

    public CepNotFoundException(){
        super("Todos os serviços de CEP retornaram erro.");
    }

}
