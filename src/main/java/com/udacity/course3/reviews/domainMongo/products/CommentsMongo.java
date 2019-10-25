package com.udacity.course3.reviews.domainMongo.products;

import javax.persistence.Id;

public class CommentsMongo {
    @Id
    private String id;

    private String commentType;

    private String commentDetail;

    public CommentsMongo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }
}
