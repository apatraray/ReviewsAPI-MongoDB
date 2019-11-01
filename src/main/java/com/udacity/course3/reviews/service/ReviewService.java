package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.domain.products.ProductsRepository;
import com.udacity.course3.reviews.domain.reviews.ReviewNotFoundException;
import com.udacity.course3.reviews.domainMongo.products.ProductRepositoryMongo;
import com.udacity.course3.reviews.domainMongo.products.ReviewRepositoryMongo;
import com.udacity.course3.reviews.domainMongo.products.ReviewsMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepositoryMongo reviewMongoRepository;

    @Autowired
    private ProductRepositoryMongo productMongoRepository;

    @Autowired
    private ProductsRepository repository;

    public ReviewService(ReviewRepositoryMongo reviewMongoRepository,
                         ProductsRepository repository, ProductRepositoryMongo productMongoRepository) {
        this.reviewMongoRepository = reviewMongoRepository;
        this.repository = repository;
        this.productMongoRepository = productMongoRepository;
    }

    /**
     * Gathers a list of all reviews
     * @return a list of all reviews in the mongoRepository
     */
    public List<ReviewsMongo> list() {
        List<ReviewsMongo> newList = reviewMongoRepository.findAll();
        return newList;
    }

    /**
     * Gets product information by ID (or throws exception if non-existent)
     * @param reviewId the ID number of the review to gather information on
     * @return the requested product's review
     */
    public ReviewsMongo findById(String reviewId) {
        Optional<ReviewsMongo> optionalReview = reviewMongoRepository.findById(reviewId);
        ReviewsMongo review = optionalReview.orElseThrow(ReviewNotFoundException::new);

        return review;
    }

    /**
     * Either creates or updates a review, based on prior existence of review
     * @param reviewsMongo A reviewsMongo object, which can be either new or existing
     * @return the new/updated reviewsMongo is stored in the repository
     */
    public ReviewsMongo save(ReviewsMongo reviewsMongo) {
        if (reviewsMongo.getId() != null) {
            return reviewMongoRepository.findById(reviewsMongo.getId())
                    .map(reviewToBeUpdated -> {
                        reviewToBeUpdated.setComments(reviewsMongo.getComments());
                        return reviewMongoRepository.save(reviewToBeUpdated);
                    }).orElseThrow(ReviewNotFoundException::new);
        }

        return reviewMongoRepository.save(reviewsMongo);
    }

    /**
     * Deletes a given review by ID
     * @param id the ID number of the review to delete
     */
   public void delete(Long id) throws ReviewNotFoundException{
        Optional<ReviewsMongo> reviewsMongoOptional = reviewMongoRepository.findById(String.valueOf(id));
        ReviewsMongo reviewsMongo = reviewsMongoOptional.orElseThrow(ReviewNotFoundException::new);
        reviewMongoRepository.delete(reviewsMongo);
    }
}
