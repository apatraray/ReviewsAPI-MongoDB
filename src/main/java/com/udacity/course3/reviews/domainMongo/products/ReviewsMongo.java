package com.udacity.course3.reviews.domainMongo.products;

import org.springframework.data.annotation.Id;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.Valid;
import java.util.List;


public class ReviewsMongo {
    @Id
    private String id;

    @Valid
    @Embedded
    private List<CommentsMongo> comments;

    public ReviewsMongo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CommentsMongo> getComments() {
        return comments;
    }

    public void setComments(List<CommentsMongo> comments) {
        this.comments = comments;
    }
}
