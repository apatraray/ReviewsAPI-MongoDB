package com.udacity.course3.reviews.domainMongo.products;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="productsMongo")
public class ProductsMongo {
    @Id
    private String id;

    private String productName;

    private String price;

    private List<String> reviewId;

    public ProductsMongo(){}

    public ProductsMongo(String productName, String price){
        this.productName = productName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<String> getReviewId() {
        return reviewId;
    }

    public void setReviewId(List<String> reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String toString() {
        return "ProductsMongo{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", reviewId=" + reviewId +
                '}';
    }
}
