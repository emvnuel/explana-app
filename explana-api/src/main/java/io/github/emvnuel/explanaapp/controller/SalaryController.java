package io.github.emvnuel.explanaapp.controller;

import io.github.emvnuel.explanaapp.controller.dto.SalaryStatisticResponse;
import io.github.emvnuel.explanaapp.mapper.SalaryMapper;
import io.github.emvnuel.explanaapp.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping
@RestController
public class SalaryController {

    private final ReviewService reviewService;
    private final SalaryMapper salaryMapper;

    public SalaryController(ReviewService reviewService, SalaryMapper salaryMapper) {
        this.reviewService = reviewService;
        this.salaryMapper = salaryMapper;
    }

    @GetMapping("/companies/{id}/salaries")
    public ResponseEntity<List<SalaryStatisticResponse>> salaryStatisticByCompany(@PathVariable String id) {
        return ResponseEntity.ok(
                reviewService.salaryStatisticsByCompany(id).stream()
                        .map(salaryMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }
}
