package io.github.emvnuel.explanaapp.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;
import static org.springframework.data.mongodb.core.mapping.FieldType.OBJECT_ID;

@Getter
@Document
public class Review {

    @Id
    private String id;
    private String title;
    private String pros;
    private String cons;
    private Double rating;
    private Job job;
    private JobLevel jobLevel;

    @Field(targetType = DECIMAL128)
    private BigDecimal salary;

    @Field(targetType = OBJECT_ID)
    private String companyId;

    private LocalDateTime createdAt;

    public Review(String title,
                  String pros,
                  String cons,
                  Double rating,
                  Job job,
                  JobLevel jobLevel,
                  BigDecimal salary) {
        this.title = title;
        this.pros = pros;
        this.cons = cons;
        this.rating = rating;
        this.job = job;
        this.jobLevel = jobLevel;
        this.salary = salary;
        createdAt = LocalDateTime.now();
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
