package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domainMongo.products.ReviewRepositoryMongo;
import com.udacity.course3.reviews.domainMongo.products.ReviewsMongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MongoDbRepositoryTest {
    @Autowired
    private ReviewRepositoryMongo reviewRepositoryMongo;

    @Test
    public void testSaveReviews(){
        ReviewsMongo review = new ReviewsMongo();
        reviewRepositoryMongo.save(review);

        Optional<ReviewsMongo> optionalReview = reviewRepositoryMongo.findById(review.getId());
        ReviewsMongo review2 = optionalReview.get();
        System.out.println("review2 "+ review2);
        assertNotNull(review);
        assertEquals(review2.getId(), review.getId());
    }

    @Test
    public void testDeleteReviews(){
        ReviewsMongo review = new ReviewsMongo();
        reviewRepositoryMongo.save(review);
        reviewRepositoryMongo.delete(review);
    }

    @Test
    public void testFindAllReviews() {
        ReviewsMongo review = new ReviewsMongo();
        reviewRepositoryMongo.save(review);
        assertNotNull(reviewRepositoryMongo.findAll());
    }
}
