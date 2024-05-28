package com.example.WebFluxTest.client;

import com.example.WebFluxTest.infra.exceptions.BankCodeNotFoundException;
import com.example.WebFluxTest.infra.exceptions.CepNotFoundException;
import com.example.WebFluxTest.model.BankResponse;
import com.example.WebFluxTest.model.CepResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BrasilClient {

private final WebClient webClient;


    public BrasilClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://brasilapi.com.br/api").build();
    }

    public Flux<BankResponse> findAllBanks(){
        return webClient.get().uri("/banks/v1")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(BankResponse.class);
    }

    public Mono<BankResponse> findBankByCode(String code){
        return webClient.get().uri("/banks/v1/" + code)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new BankCodeNotFoundException()))
                .bodyToMono(BankResponse.class);
    }

    public Mono<CepResponse> findLocationByCep(String cep){
        return webClient.get().uri("/cep/v1/" + cep)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new CepNotFoundException()))
                .bodyToMono(CepResponse.class);
    }


}
