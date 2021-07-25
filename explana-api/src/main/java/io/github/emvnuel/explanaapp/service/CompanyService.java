package io.github.emvnuel.explanaapp.service;

import io.github.emvnuel.explanaapp.model.Company;
import io.github.emvnuel.explanaapp.model.Review;
import io.github.emvnuel.explanaapp.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company findById(String id) {
        return companyRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Company addReview(String id, Review review) {
        Company company = findById(id);
        company.addReview(review);
        return save(company);
    }

}
