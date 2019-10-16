package com.udacity.course3.reviews.domain.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReviewsRepository  extends JpaRepository<Reviews, Integer> {

    @Transactional
    @Modifying
    @Query("update Reviews r set r.comment.id = :commentId where r.product.id = :productId")
    void updateReviewForComment(Integer productId, Integer commentId);

    @Query("select r.id from Reviews r where r.product.id = :productId")
    List<Integer> findReviewsForProduct(Integer productId);

    @Query("select r.product.id from Reviews r where r.id=:reviewId")
    Integer findProductByReviewId(Integer reviewId);

    @Query("select r.comment.id, r.product.id, r.id from Reviews r where r.product.id=:productId")
    List<Integer> findCommentsForProduct(Integer productId);

}
