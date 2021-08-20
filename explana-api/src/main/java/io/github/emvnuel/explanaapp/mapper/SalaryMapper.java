package io.github.emvnuel.explanaapp.mapper;

import io.github.emvnuel.explanaapp.controller.dto.SalaryStatisticResponse;
import io.github.emvnuel.explanaapp.repository.projections.SalaryStatistic;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;

@Component
public class SalaryMapper {

    public SalaryStatisticResponse toDTO(SalaryStatistic salaryStatistic) {
        return new SalaryStatisticResponse(salaryStatistic.getJob().getDescription(),
                salaryStatistic.getJobLevel().getDescription(),
                salaryStatistic.getAvgSalary().setScale(2, RoundingMode.HALF_EVEN),
                salaryStatistic.getTotal());
    }
}
