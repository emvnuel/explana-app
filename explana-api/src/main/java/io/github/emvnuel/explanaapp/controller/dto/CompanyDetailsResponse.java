package io.github.emvnuel.explanaapp.controller.dto;

import io.github.emvnuel.explanaapp.model.Review;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class CompanyDetailsResponse {

    String id;
    String name;
    String description;
    String imageUrl;
    BigDecimal rating;
    List<Review> reviews;

}
