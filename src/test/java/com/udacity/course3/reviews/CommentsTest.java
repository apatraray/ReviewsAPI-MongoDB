package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.comments.Comments;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CommentsTest {
    private static final String PERSISTENCE_UNIT_NAME="CommentsMongo";
    private static EntityManagerFactory factory;

    public static void main(String args[]){
        factory= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Comments comment = new Comments();
        comment.setCommentType("nice");
        comment.setCommentDetail("works perfect");
        em.persist(comment);

        System.err.println("comment id "+ comment.getId());

        em.getTransaction().commit();

        em.close();

        readComment(comment.getId(), factory);
        factory.close();
    }

    private static void readComment(Integer id, EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();

        Comments comment = em.find(Comments.class, id);

        System.err.println("comment: "+ comment);

        em.close();
    }
}
