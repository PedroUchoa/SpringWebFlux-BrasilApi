package com.example.WebFluxTest.model;

public record CepResponse(String cep, String state, String city, String neighborhood, String street, String service ) {
}
