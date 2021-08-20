package io.github.emvnuel.explanaapp.repository;

import io.github.emvnuel.explanaapp.repository.projections.SalaryStatistic;

import java.math.BigDecimal;
import java.util.List;

public interface ReviewCustomRepository {

    BigDecimal avgSalaryByCompany(String companyId);

    List<SalaryStatistic> avgSalariesByCompany(String companyId);

    Double avgRatingByCompany(String companyId);
}
