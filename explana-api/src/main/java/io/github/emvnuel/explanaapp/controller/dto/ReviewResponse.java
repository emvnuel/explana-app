package io.github.emvnuel.explanaapp.controller.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ReviewResponse {

    String title;
    String pros;
    String cons;
    Integer rating;
    String job;
    String jobLevel;
    LocalDate createdAt;
}
