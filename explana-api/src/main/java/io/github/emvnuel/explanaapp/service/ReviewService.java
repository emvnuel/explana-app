package io.github.emvnuel.explanaapp.service;

import io.github.emvnuel.explanaapp.model.Review;
import io.github.emvnuel.explanaapp.repository.ReviewRepository;
import io.github.emvnuel.explanaapp.repository.projections.SalaryStatistic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void addReview(String companyId, Review review) {
        review.setCompanyId(companyId);
        reviewRepository.save(review);
    }

    public Page<Review> findAllReviewsByCompanyId(String companyId, Pageable pageable) {
        return reviewRepository.findAllByCompanyId(companyId, pageable);
    }

    public BigDecimal avgSalaryByCompany(String companyId) {
        return reviewRepository.avgSalaryByCompany(companyId);
    }

    public List<SalaryStatistic> salaryStatisticsByCompany(String companyId) {
        return reviewRepository.avgSalariesByCompany(companyId);
    }

    public Double avgRatingByCompany(String id) {
        return reviewRepository.avgRatingByCompany(id);
    }
}
