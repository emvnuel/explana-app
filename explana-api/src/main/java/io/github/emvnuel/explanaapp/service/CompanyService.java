package io.github.emvnuel.explanaapp.service;

import io.github.emvnuel.explanaapp.model.Company;
import io.github.emvnuel.explanaapp.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ReviewService reviewService;

    public CompanyService(CompanyRepository companyRepository, ReviewService reviewService) {
        this.companyRepository = companyRepository;
        this.reviewService = reviewService;
    }

    public Page<Company> findAll(Pageable pageable) {
        Page<Company> companies = companyRepository.findAll(pageable);
        companies.forEach(company -> company.setAvgRating(reviewService.avgRatingByCompany(company.getId())));
        return companies;
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company findById(String id) {
        Company company = companyRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        company.setAvgRating(reviewService.avgRatingByCompany(company.getId()));
        company.setAvgSalary(reviewService.avgSalaryByCompany(company.getId()));
        return company;
    }

}
