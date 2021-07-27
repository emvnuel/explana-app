package io.github.emvnuel.explanaapp.repository;

import io.github.emvnuel.explanaapp.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String>, ReviewCustomRepository {

    Page<Review> findAllByCompanyId(String companyId, Pageable pageable);

}
