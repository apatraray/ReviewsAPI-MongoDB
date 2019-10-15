package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.products.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductsTest {
    private static final String PERSISTENCE_UNIT_NAME="Products";
    private static EntityManagerFactory factory;

    public static void main(String args[]){
        factory= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Products product = new Products();
 //       product1.setID(1);
        product.setProductName("smart watches");
        product.setPrice("$199");

        em.persist(product);

        System.err.println("product id "+ product.getID());

        em.getTransaction().commit();

        em.close();

        readProduct(product.getID(), factory);
        factory.close();
    }

    private static void readProduct(Integer id, EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();

        Products product = em.find(Products.class, id);

        System.err.println("product: "+ product);

        em.close();
    }
}
