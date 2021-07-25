package io.github.emvnuel.explanaapp.controller.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CompanyResponse {

    String id;
    String name;
    String description;
    String imageUrl;
    BigDecimal rating;

}
