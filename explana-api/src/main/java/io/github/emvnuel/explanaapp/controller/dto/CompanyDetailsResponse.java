package io.github.emvnuel.explanaapp.controller.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CompanyDetailsResponse {

    String id;
    String name;
    String description;
    String imageUrl;
    BigDecimal rating;
    BigDecimal avgSalary;
}
