package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.comments.CommentNotFoundException;
import com.udacity.course3.reviews.domain.comments.Comments;
import com.udacity.course3.reviews.domain.comments.CommentsRepository;
import com.udacity.course3.reviews.domain.reviews.ReviewNotFoundException;
import com.udacity.course3.reviews.domain.reviews.Reviews;
import com.udacity.course3.reviews.domain.reviews.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    // TODO: Wire needed JPA repositories here
    @Autowired
    private CommentsRepository commentRepository;

    @Autowired
    private ReviewsRepository reviewRepository;

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId, @Valid @RequestBody Comments newComment) {
        Optional<Reviews> optionalReview = reviewRepository.findById(reviewId);
        Reviews review = optionalReview.orElseThrow(ReviewNotFoundException::new);

        if (review != null){
            Comments comment = newComment;
            review.setComment(comment);
            commentRepository.save(comment);
                return new ResponseEntity<>(comment,
                        HttpStatus.OK);
            }
            throw new CommentNotFoundException();
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Integer productId = reviewRepository.findProductByReviewId(reviewId);
        List<Comments> newList = new ArrayList<>();

        List<Integer> commentIds= reviewRepository.findCommentsForProduct(productId);
        for (int commentId: commentIds){
            Optional<Comments> optionalComment = commentRepository.findById(commentId);
            Comments comment = optionalComment.orElseThrow(CommentNotFoundException::new);
            newList.add(comment);
        }
        return new ResponseEntity<>(newList,
                HttpStatus.OK);
    }
}