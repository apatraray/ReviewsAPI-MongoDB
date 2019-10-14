package com.udacity.course3.reviews.domain.comments;

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

    public Comments() {
    }

    public Comments(String commentType, String commentDetail) {
        this.commentType = commentType;
        this.commentDetail = commentDetail;
    }
    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", commentType='" + commentType + '\'' +
                ", commentDetail='" + commentDetail + '\'' +
                '}';
    }
}