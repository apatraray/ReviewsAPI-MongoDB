package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.products.ProductNotFoundException;
import com.udacity.course3.reviews.domain.products.Products;
import com.udacity.course3.reviews.domain.products.ProductsRepository;
import com.udacity.course3.reviews.domain.reviews.ReviewNotFoundException;
import com.udacity.course3.reviews.domain.reviews.Reviews;
import com.udacity.course3.reviews.domain.reviews.ReviewsRepository;
import com.udacity.course3.reviews.domainMongo.products.CommentsMongo;
import com.udacity.course3.reviews.domainMongo.products.ProductRepositoryMongo;
import com.udacity.course3.reviews.domainMongo.products.ProductsMongo;
import com.udacity.course3.reviews.domainMongo.products.ReviewsMongo;
import com.udacity.course3.reviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewsRepository reviewRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductRepositoryMongo productRepositoryMongo;
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
    public ResponseEntity<?> createReviewForProduct(@PathVariable("productId") Integer productId, @Valid @RequestBody Reviews newReview) {
        Optional<Products> optionalProduct = productsRepository.findById(productId);
        Products product = optionalProduct.orElseThrow(ProductNotFoundException::new);
        if (product != null){
            Reviews review = newReview;
            review.setProduct(product);
            reviewRepository.save(review);
            ReviewsMongo reviewsMongo = new ReviewsMongo();
            List<CommentsMongo> commentsMongos = new ArrayList<>();
            CommentsMongo commentsMongo = new CommentsMongo();
      //      commentsMongo.setCommentDetail(review.getComment().getCommentDetail());
        //    commentsMongo.setCommentType(review.getComment().getCommentType());
            commentsMongos.add(commentsMongo);
            reviewsMongo.setComments(commentsMongos);
            reviewService.save(reviewsMongo);
            return new ResponseEntity<>(reviewsMongo,
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
        List<ReviewsMongo> newList = new ArrayList<>();

            //for ReviewRepository mongo
        if (product != null){
            Optional<ProductsMongo> productsMongoOptional = productRepositoryMongo.findById(String.valueOf(productId));
            ProductsMongo productsMongo = productsMongoOptional.orElseThrow(ProductNotFoundException::new);
            List<String> reviewIds= productsMongo.getReviewId();

            for (String reviewId: reviewIds) {
                ReviewsMongo newReview = reviewService.findById(reviewId);
                newList.add(newReview);
            }
        }

        return new ResponseEntity<>(newList,
                HttpStatus.OK);
    }
}