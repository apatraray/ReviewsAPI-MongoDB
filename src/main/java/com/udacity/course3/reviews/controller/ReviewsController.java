package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.products.ProductNotFoundException;
import com.udacity.course3.reviews.domain.products.Products;
import com.udacity.course3.reviews.domain.products.ProductsRepository;
import com.udacity.course3.reviews.domain.reviews.ReviewNotFoundException;
import com.udacity.course3.reviews.domain.reviews.Reviews;
import com.udacity.course3.reviews.domain.reviews.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    // TODO: Wire JPA repositories here
    @Autowired
    private ReviewsRepository reviewRepository;

    @Autowired
    private ProductsRepository productsRepository;

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId) {
        Optional<Products> optionalProduct = productsRepository.findById(productId);
        Products product = optionalProduct.orElseThrow(ProductNotFoundException::new);
        if (product != null){
            Reviews review = new Reviews();
            reviewRepository.save(review);
            return new ResponseEntity<>(review,
                    HttpStatus.OK);
        }
        throw new ReviewNotFoundException();
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        Optional<Products> optionalProduct = productsRepository.findById(productId);
        Products product = optionalProduct.orElseThrow(ProductNotFoundException::new);
        List<Reviews> newList = new ArrayList<>();

        if (product != null){
            List<Integer> reviewIds= reviewRepository.findReviewsForProduct(productId);
            for (int reviewId: reviewIds){
                Optional<Reviews> optionalReview = reviewRepository.findById(reviewId);
                Reviews review = optionalReview.orElseThrow(ReviewNotFoundException::new);
                newList.add(review);
            }
        }
        return new ResponseEntity<>(newList,
                HttpStatus.OK);
    }
}