package com.udacity.course3.reviews.domain.reviews;

import com.udacity.course3.reviews.domain.comments.Comments;
import com.udacity.course3.reviews.domain.products.Products;
import javax.persistence.*;

@Embeddable
@Entity
@Table(name="reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Reviews() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }

    public Reviews(Comments comment) {
        this.comment = comment;
    }

    public Reviews(Products product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comments comment;

    @OneToOne
    @JoinColumn(name="product_id")
    private Products product;

    @Override
    public String toString() {
        return "ReviewsMongo{" +
                "id=" + id +
                ", comment=" + comment +
                ", product=" + product +
                '}';
    }
}