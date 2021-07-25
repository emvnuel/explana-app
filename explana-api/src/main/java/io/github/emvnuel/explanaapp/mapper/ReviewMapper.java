package io.github.emvnuel.explanaapp.mapper;

import io.github.emvnuel.explanaapp.controller.dto.ReviewRequest;
import io.github.emvnuel.explanaapp.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review toModel(ReviewRequest reviewRequest) {
        return new Review(reviewRequest.getTitle(),
                reviewRequest.getBody(),
                reviewRequest.getPros(),
                reviewRequest.getCons(),
                Double.valueOf(reviewRequest.getRating()),
                reviewRequest.getJob(),
                reviewRequest.getJobLevel(),
                reviewRequest.getSalary());
    }

}
