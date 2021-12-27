package com.test.main.entities;

import java.util.HashSet;

/**
 *
 * @author frank
 */
public class Cart {
    private Integer id;
    private HashSet<Product> products;

    public Cart(Integer id) {
        this.id = id;
        this.products = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HashSet<Product> getProducts() {
        return products;
    }

    public void setProducts(HashSet<Product> product) {
        this.products = product;
    }
}
