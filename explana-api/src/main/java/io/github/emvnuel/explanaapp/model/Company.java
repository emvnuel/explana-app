package io.github.emvnuel.explanaapp.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Document
public class Company {

    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private List<Review> reviews = new ArrayList<>();

    public Company(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Double getAvgRating() {
        return reviews.stream().mapToDouble(Review::getRating).average().orElse(5);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

}
