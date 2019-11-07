package com.udacity.course3.reviews.domainMongo.products;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepositoryMongo extends MongoRepository<ReviewsMongo, String> {
}
