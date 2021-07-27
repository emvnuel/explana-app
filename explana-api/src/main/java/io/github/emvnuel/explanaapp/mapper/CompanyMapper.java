package io.github.emvnuel.explanaapp.mapper;

import io.github.emvnuel.explanaapp.controller.dto.CompanyDetailsResponse;
import io.github.emvnuel.explanaapp.controller.dto.CompanyRequest;
import io.github.emvnuel.explanaapp.controller.dto.CompanyResponse;
import io.github.emvnuel.explanaapp.model.Company;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CompanyMapper {

    public CompanyResponse toCompanyResponse(Company company) {
        return new CompanyResponse(company.getId(),
                company.getName(),
                company.getDescription(),
                company.getImageUrl(),
                BigDecimal.valueOf(company.getAvgRating()).setScale(2, RoundingMode.HALF_UP));
    }

    public CompanyDetailsResponse toCompanyDetailsResponse(Company company) {
        return new CompanyDetailsResponse(company.getId(),
                company.getName(),
                company.getDescription(),
                company.getImageUrl(),
                BigDecimal.valueOf(company.getAvgRating()).setScale(2, RoundingMode.HALF_UP),
                company.getAvgSalary().setScale(2, RoundingMode.HALF_UP));
    }

    public Company toModel(CompanyRequest companyRequest) {
        return new Company(companyRequest.getName(),
                companyRequest.getDescription(),
                companyRequest.getImageUrl());
    }

}
