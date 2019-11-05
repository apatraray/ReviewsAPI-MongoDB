package com.udacity.course3.reviews.domainMongo.products;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepositoryMongo extends MongoRepository<ProductsMongo, String> {
//    List<Integer> findReviewsForProduct(Integer productId);
}
