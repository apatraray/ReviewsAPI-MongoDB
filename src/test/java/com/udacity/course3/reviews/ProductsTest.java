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

        Products product1 = new Products();
 //       product1.setID(1);
        product1.setProductName("smart watches");
        product1.setPrice("$199");

        em.persist(product1);

        System.err.println("product id "+ product1.getID());

        em.getTransaction().commit();

        em.close();

        readProduct(product1.getID(), factory);
        factory.close();
    }

    private static void readProduct(Integer id, EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();

        Products product = em.find(Products.class, id);

        System.err.println("product: "+ product);

        em.close();
    }
}
