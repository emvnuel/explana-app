package io.github.emvnuel.explanaapp.repository.projections;

import io.github.emvnuel.explanaapp.model.Job;
import io.github.emvnuel.explanaapp.model.JobLevel;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Objects;

@Value
public class SalaryStatistic {

    Job job;
    JobLevel jobLevel;
    BigDecimal avgSalary;
    Integer total;

    public SalaryStatistic setTotal(Integer total) {
        return new SalaryStatistic(this.job, this.jobLevel, this.avgSalary, total);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryStatistic that = (SalaryStatistic) o;
        return job == that.job && jobLevel == that.jobLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, jobLevel);
    }
}
