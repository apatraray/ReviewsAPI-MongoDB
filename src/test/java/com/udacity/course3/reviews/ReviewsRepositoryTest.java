package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.reviews.Reviews;
import com.udacity.course3.reviews.domain.reviews.ReviewsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import javax.persistence.EntityManager;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired private TestEntityManager testEntityManager;
    @Autowired private ReviewsRepository reviewRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        assertNotNull(entityManager);
        assertNotNull(testEntityManager);
        assertNotNull(reviewRepository);
    }

    @Test
    public void testSaveReviews(){
        Reviews review = new Reviews(1, 1);
        reviewRepository.save(review);

        Optional<Reviews> optionalReview = reviewRepository.findById(review.getId());
        Reviews review2 = optionalReview.get();
        System.out.println("review2 "+ review2);
        assertNotNull(review);
        assertEquals(review2.getProductId(), review.getProductId());
        assertEquals(review2.getCommentId(), review.getCommentId());

    }

    @Test
    public void testDeleteReviews(){
        Reviews review = new Reviews(1, 1);
        reviewRepository.save(review);
        reviewRepository.delete(review);
    }

    @Test
    public void testFindAllReviews() {
        Reviews review = new Reviews(1, 1);
        reviewRepository.save(review);
        assertNotNull(reviewRepository.findAll());
    }

    @Test
    public void testReviewsUpdate() {
        Reviews review = new Reviews(1, 1);
        reviewRepository.save(review);

        Optional<Reviews> optionalReview = reviewRepository.findById(review.getId());
        Reviews review2 = optionalReview.get();
        review2.setCommentId(10);
        review2.setProductId(15);
        reviewRepository.save(review2);
    }
}

