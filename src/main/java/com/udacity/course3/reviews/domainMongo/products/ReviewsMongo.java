package com.udacity.course3.reviews.domainMongo.products;

import org.springframework.data.annotation.Id;

import java.util.List;

public class ReviewsMongo {
    @Id
    private String id;

    private List<String> comments;

    public ReviewsMongo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
