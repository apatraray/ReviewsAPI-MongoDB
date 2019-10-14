package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.reviews.Reviews;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReviewsTest {
    private static final String PERSISTENCE_UNIT_NAME="Reviews";
    private static EntityManagerFactory factory;

    public static void main(String args[]){
        factory= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Reviews review = new Reviews();
        review.setProductId(1);
        review.setCommentId(4);
        em.persist(review);

        System.err.println("review id "+ review.getId());

        em.getTransaction().commit();

        em.close();

        readProduct(review.getId(), factory);
        factory.close();
    }

    private static void readProduct(Integer id, EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();

        Reviews review = em.find(Reviews.class, id);

        System.err.println("review: "+ review);

        em.close();
    }
}