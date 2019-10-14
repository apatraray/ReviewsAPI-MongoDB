package com.udacity.course3.reviews.domain.products;

import com.udacity.course3.reviews.domain.comments.Comments;
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

    @OneToMany(cascade=ALL, fetch = FetchType.EAGER)
    @JoinTable(name="reviews", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="comment_id"))
    private List<Comments> comments = new ArrayList<>();

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
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
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}