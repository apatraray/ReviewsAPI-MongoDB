package com.udacity.course3.reviews.domain.comments;

import com.udacity.course3.reviews.domain.reviews.Reviews;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="comments")
public class Comments implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="comment_type")
    private String commentType;

    @Column(name="comment_detail")
    private String commentDetail;

    public Comments() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Comments(String commentType, String commentDetail) {
        this.commentType = commentType;
        this.commentDetail = commentDetail;
    }

    @ManyToOne
    @JoinColumn(name="review_id")
    private Reviews reviews;

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "CommentsMongo{" +
                "id=" + id +
                ", commentType='" + commentType + '\'' +
                ", commentDetail='" + commentDetail + '\'' +
                '}';
    }
}