package com.udacity.course3.reviews.domain.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository  extends JpaRepository<Reviews, Integer> {
}
