package com.udacity.course3.reviews.domain.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product not found")
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
