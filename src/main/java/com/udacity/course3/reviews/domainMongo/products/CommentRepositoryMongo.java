package com.udacity.course3.reviews.domainMongo.products;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepositoryMongo extends MongoRepository<CommentsMongo, String> {
}
