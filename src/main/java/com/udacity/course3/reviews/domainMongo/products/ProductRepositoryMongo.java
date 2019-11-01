package com.udacity.course3.reviews.domainMongo.products;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepositoryMongo extends MongoRepository<ProductsMongo, String> {
    List<Integer> findReviewsForProduct(Integer productId);
}
