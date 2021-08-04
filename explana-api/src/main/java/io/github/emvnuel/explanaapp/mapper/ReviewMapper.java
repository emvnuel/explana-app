package io.github.emvnuel.explanaapp.mapper;

import io.github.emvnuel.explanaapp.controller.dto.ReviewRequest;
import io.github.emvnuel.explanaapp.controller.dto.ReviewResponse;
import io.github.emvnuel.explanaapp.model.Review;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class ReviewMapper {

    public Review toModel(ReviewRequest reviewRequest) {
        return new Review(reviewRequest.getTitle(),
                reviewRequest.getPros(),
                reviewRequest.getCons(),
                Double.valueOf(reviewRequest.getRating()),
                reviewRequest.getJob(),
                reviewRequest.getJobLevel(),
                reviewRequest.getSalary());
    }

    public ReviewResponse toDTO(Review review) {
        return new ReviewResponse(review.getTitle(),
                review.getPros(),
                review.getCons(),
                review.getRating().intValue(),
                review.getJob().getDescription(),
                review.getJobLevel().getDescription(),
                review.getCreatedAt().toLocalDate());
    }
}
