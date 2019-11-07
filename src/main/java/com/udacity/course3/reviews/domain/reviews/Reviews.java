package com.udacity.course3.reviews.domain.reviews;

import com.udacity.course3.reviews.domain.comments.Comments;
import com.udacity.course3.reviews.domain.products.Products;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

/*    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }

    public Reviews(Comments comment) {
        this.comment = comment;
    }
*/
    public Reviews(Products product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @OneToMany(mappedBy = "reviews")
 //   @JoinColumn(name = "comment_id")
    private List<Comments> Comments = new ArrayList<>();
//    private Comments comment;

    public List<com.udacity.course3.reviews.domain.comments.Comments> getComments() {
        return Comments;
    }

    public void setComments(List<com.udacity.course3.reviews.domain.comments.Comments> comments) {
        Comments = comments;
    }

    @Override
    public String toString() {
        return "ReviewsMongo{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}