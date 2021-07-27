package io.github.emvnuel.explanaapp.repository;

import java.math.BigDecimal;

public interface ReviewCustomRepository {

    BigDecimal avgSalaryByCompany(String companyId);

    Double avgRatingByCompany(String companyId);
}
