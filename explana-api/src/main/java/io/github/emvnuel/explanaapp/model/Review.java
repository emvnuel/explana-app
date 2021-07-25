package io.github.emvnuel.explanaapp.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Document
public class Review {

    @Id
    private String id;
    private String title;
    private String body;
    private String pros;
    private String cons;
    private Double rating;
    private Job job;
    private JobLevel jobLevel;
    private BigDecimal salary;

    public Review(String title,
                  String body,
                  String pros,
                  String cons,
                  Double rating,
                  Job job,
                  JobLevel jobLevel,
                  BigDecimal salary) {
        this.title = title;
        this.body = body;
        this.pros = pros;
        this.cons = cons;
        this.rating = rating;
        this.job = job;
        this.jobLevel = jobLevel;
        this.salary = salary;
    }

}
