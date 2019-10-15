package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.products.Products;
import com.udacity.course3.reviews.domain.products.ProductsRepository;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.activation.DataSource;
import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductsRepositoryTest {
    @Autowired private EntityManager entityManager;
    @Autowired private TestEntityManager testEntityManager;
    @Autowired private ProductsRepository productRepository;

    @Test
    public void injectedComponentsAreNotNull(){
        assertNotNull(entityManager);
        assertNotNull(testEntityManager);
        assertNotNull(productRepository);
    }

    @Test
    public void testSaveProducts(){
        Products product = new Products("mobile phone", "$199");
        productRepository.save(product);

        Products product2 = productRepository.findByProductName("mobile phone");
        System.out.println("product2 "+product2);
        assertNotNull(product);
        assertEquals(product2.getProductName(), product.getProductName());
        assertEquals(product2.getPrice(), product.getPrice());

    }

    @Test
    public void testDeleteProducts(){
        Products product = new Products("mobile phone", "$199");
        productRepository.save(product);
        productRepository.delete(product);
    }

    @Test
    public void testFindAllProducts() {
        Products product = new Products("mobile phone", "$199");
        productRepository.save(product);
        assertNotNull(productRepository.findAll());
    }

    @Test
    public void testProductsUpdate() {
        Products product = new Products("mobile phone", "$199");
        Products product1 = productRepository.save(product);

        Optional<Products> optionalProduct = productRepository.findById(product1.getID());
        Products product2 = optionalProduct.get();
        product2.setProductName("smart phone");
        product2.setPrice("$500");

        productRepository.save(product2);
    }
}

