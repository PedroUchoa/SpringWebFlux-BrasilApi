package com.example.WebFluxTest.controller;

import com.example.WebFluxTest.client.BrasilClient;
import com.example.WebFluxTest.model.BankResponse;
import com.example.WebFluxTest.model.CepResponse;
import com.example.WebFluxTest.model.DDDResponse;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/cep/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CepResponse> findLocationByCep(@PathVariable String cep){
        return brasilClient.findLocationByCep(cep);
    }

    @GetMapping("/ddd/{ddd}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DDDResponse> findLocationVyDDD(@PathVariable String ddd){
        return brasilClient.findLocationVyDDD(ddd);
    }

}
