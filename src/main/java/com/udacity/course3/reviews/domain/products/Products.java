package com.udacity.course3.reviews.domain.products;

import com.udacity.course3.reviews.domain.reviews.Reviews;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_price")
    private String price;

    public Products(){}

    public Products(String productName, String price){
        this.productName = productName;
        this.price = price;
    }

    @OneToMany(cascade=ALL, fetch = FetchType.EAGER, mappedBy = "product")
//    @JoinTable(name="reviews", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="comment_id"))
    private List<Reviews> reviews = new ArrayList<>();

/*    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
*/

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductsMongo{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}