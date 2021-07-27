package io.github.emvnuel.explanaapp.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Document
public class Company {

    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;

    @Transient
    private Double avgRating;

    @Transient
    private BigDecimal avgSalary;

    public Company(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public void setAvgSalary(BigDecimal avgSalary) {
        this.avgSalary = avgSalary;
    }
}
