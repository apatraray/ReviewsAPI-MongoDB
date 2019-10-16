package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.reviews.Reviews;
import com.udacity.course3.reviews.domain.reviews.ReviewsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsRepositoryTest {
    @Autowired private ReviewsRepository reviewRepository;

    @Test
    public void testSaveReviews(){
        Reviews review = new Reviews();
        reviewRepository.save(review);

        Optional<Reviews> optionalReview = reviewRepository.findById(review.getId());
        Reviews review2 = optionalReview.get();
        System.out.println("review2 "+ review2);
        assertNotNull(review);
        assertEquals(review2.getId(), review.getId());
    }

    @Test
    public void testDeleteReviews(){
        Reviews review = new Reviews();
        reviewRepository.save(review);
        reviewRepository.delete(review);
    }

    @Test
    public void testFindAllReviews() {
        Reviews review = new Reviews();
        reviewRepository.save(review);
        assertNotNull(reviewRepository.findAll());
    }

}

