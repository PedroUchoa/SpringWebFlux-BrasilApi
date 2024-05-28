package com.example.WebFluxTest.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record BankResponse(String ispb, String name,Integer code,String fullName) {
}
