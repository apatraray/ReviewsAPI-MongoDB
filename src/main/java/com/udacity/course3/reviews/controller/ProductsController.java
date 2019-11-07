package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.products.ProductNotFoundException;
import com.udacity.course3.reviews.domain.products.Products;
import com.udacity.course3.reviews.domain.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with product entity.
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

    // TODO: Wire JPA repositories here
    @Autowired
    private ProductsRepository repository;
    /**
     * Creates a product.
     *
     * 1. Accept product as argument. Use {@link RequestBody} annotation.
     * 2. Save product.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Products createProduct(@Valid @RequestBody Products product) {
            if (product.getID() != null) {
                return repository.findById(product.getID())
                        .map(productToBeUpdated -> {
                            productToBeUpdated.setProductName(product.getProductName());
                            productToBeUpdated.setPrice(product.getPrice());
                            return repository.save(productToBeUpdated);
                        }).orElseThrow(ProductNotFoundException::new);
            }
            return repository.save(product);
//        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Finds a product by id.
     *
     * @param id The id of the product.
     * @return The product if found, or a 404 not found.
     */
    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<Products> optionalProduct = repository.findById(id);
        Products product = optionalProduct.orElseThrow(ProductNotFoundException::new);
        return new ResponseEntity<>(product,
                HttpStatus.OK);
//        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Lists all products.
     *
     * @return The list of products.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<?> listProducts() {
        List<ResponseEntity<?>> newList = new ArrayList<>();
        int listLength = repository.findAll().size();
        for (int id=1; id<= listLength; id++){
            ResponseEntity<?> product = findById(id);
            newList.add(product);
        }
        return newList;
    }
}