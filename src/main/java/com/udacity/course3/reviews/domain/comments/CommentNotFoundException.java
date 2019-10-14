package com.udacity.course3.reviews.domain.comments;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Comment not found")
public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException() {
    }

    public CommentNotFoundException(String message) {
        super(message);
    }
}
