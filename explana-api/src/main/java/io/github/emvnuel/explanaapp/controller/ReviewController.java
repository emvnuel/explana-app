package io.github.emvnuel.explanaapp.controller;

import io.github.emvnuel.explanaapp.controller.dto.CompanyDetailsResponse;
import io.github.emvnuel.explanaapp.controller.dto.ReviewRequest;
import io.github.emvnuel.explanaapp.controller.dto.ReviewResponse;
import io.github.emvnuel.explanaapp.mapper.ReviewMapper;
import io.github.emvnuel.explanaapp.model.Review;
import io.github.emvnuel.explanaapp.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping
@RestController
public class ReviewController {

    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;

    public ReviewController(ReviewMapper reviewMapper,
                            ReviewService reviewService) {
        this.reviewMapper = reviewMapper;
        this.reviewService = reviewService;
    }

    @PostMapping("/companies/{id}/reviews")
    public ResponseEntity<CompanyDetailsResponse> reviewCompany(@PathVariable("id") String companyId,
                                                                @Valid @RequestBody ReviewRequest reviewRequest) {
        Review review = reviewMapper.toModel(reviewRequest);
        reviewService.addReview(companyId, review);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/companies/{id}/reviews")
    public ResponseEntity<Page<ReviewResponse>> findReviewsByCompany(@PathVariable("id") String companyId,
                                                                     @PageableDefault(size = 2, page = 0) Pageable pageable) {
        return ResponseEntity.ok(reviewService.findAllReviewsByCompanyId(companyId, pageable).map(reviewMapper::toDTO));
    }

}
