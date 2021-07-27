package io.github.emvnuel.explanaapp.repository;

import io.github.emvnuel.explanaapp.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String>, ReviewCustomRepository {

}
