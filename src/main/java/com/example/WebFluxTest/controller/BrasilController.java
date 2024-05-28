package com.example.WebFluxTest.controller;

import com.example.WebFluxTest.client.BrasilClient;
import com.example.WebFluxTest.model.BankResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class BrasilController {

    private BrasilClient brasilClient;

    public BrasilController(BrasilClient brasilClient) {
        this.brasilClient = brasilClient;
    }

    @GetMapping("/banks/v1")
    @ResponseStatus(HttpStatus.OK)
    public Flux<BankResponse> findAllBanks(){
        return brasilClient.findAllBanks();
    }

    @GetMapping("/banks/v1/{code}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BankResponse> findBankByCode(@PathVariable String code){
        return brasilClient.findBankByCode(code);
    }

}
