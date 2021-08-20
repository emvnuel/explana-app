package io.github.emvnuel.explanaapp.controller.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class SalaryStatisticResponse {

    String job;
    String jobLevel;
    BigDecimal avgSalary;
    Integer total;
}
