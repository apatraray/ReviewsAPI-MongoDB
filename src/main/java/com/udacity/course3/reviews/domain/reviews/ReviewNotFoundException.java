package com.udacity.course3.reviews.domain.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Review not found")
public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException() {
    }

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
