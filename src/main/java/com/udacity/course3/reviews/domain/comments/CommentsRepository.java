package com.udacity.course3.reviews.domain.comments;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer> {
}
