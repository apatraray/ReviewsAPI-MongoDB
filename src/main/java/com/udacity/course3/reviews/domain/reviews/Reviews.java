package com.udacity.course3.reviews.domain.reviews;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="product_id")
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Column(name="comment_id")
    private Integer commentId;

    public Reviews() {
    }

    public Reviews(Integer productId, Integer commentId) {
        this.productId = productId;
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", productId=" + productId +
                ", commentId=" + commentId +
                '}';
    }
}