package io.github.emvnuel.explanaapp.repository;

import io.github.emvnuel.explanaapp.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
