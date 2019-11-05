package com.udacity.course3.reviews.domainMongo.products;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class CommentsMongo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "CommentsMongo{" +
                "id='" + id + '\'' +
                ", commentType='" + commentType + '\'' +
                ", commentDetail='" + commentDetail + '\'' +
                '}';
    }
}
