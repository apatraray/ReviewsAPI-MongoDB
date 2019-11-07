package com.udacity.course3.reviews.domain.comments;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer> {
    @Query("select c.id from Comments c where c.reviews.id=:reviewId")
    List<Integer> findCommentsForReview(Integer reviewId);
}
