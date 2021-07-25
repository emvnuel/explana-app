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
    @Length(min = 3)
    private String title;

    @NotEmpty
    @Length(min = 10)
    private String body;

    @NotEmpty
    @Length(min = 10)
    private String pros;

    @NotEmpty
    @Length(min = 10)
    private String cons;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @NotNull
    private Job job;

    @NotNull
    private JobLevel jobLevel;

    @NotNull
    @Positive
    private BigDecimal salary;

}
