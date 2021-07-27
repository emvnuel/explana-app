package io.github.emvnuel.explanaapp.controller.dto;

import io.github.emvnuel.explanaapp.model.Job;
import io.github.emvnuel.explanaapp.model.JobLevel;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Value
public class ReviewRequest {

    @NotEmpty
    @Length(min = 3, max = 28)
    String title;

    @NotEmpty
    @Length(min = 10)
    String pros;

    @NotEmpty
    @Length(min = 10)
    String cons;

    @NotNull
    @Min(1)
    @Max(5)
    Integer rating;

    @NotNull
    Job job;

    @NotNull
    JobLevel jobLevel;

    @NotNull
    @Positive
    BigDecimal salary;

}
