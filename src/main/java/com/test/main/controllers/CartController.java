package com.test.main.controllers;

import com.test.main.entities.Cart;
import com.test.main.entities.Product;
import java.util.HashSet;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author frank
 */
@EnableScheduling
@RestController
public class CartController {

    //Entiendo que solo se puede crear un carrito,
    //sino hubiera creado un HashSet de carritos.
    private Cart volatileCart;

    @PostMapping("/cart/{id}")
    public Cart createCart(@PathVariable Integer id) {
        return volatileCart = new Cart(id);
    }

    @GetMapping("/cart/{id}")
    public Cart returnCart(@PathVariable Integer id) {
        if (volatileCart.getId().equals(id)) {
            return volatileCart;
        }
        return null;
    }

    @PutMapping("/cart/{id}")
    public void addProducts(@RequestBody HashSet<Product> products, @PathVariable Integer id) {
        if (volatileCart.getId().equals(id)) {
            if (volatileCart.getProducts().isEmpty()) {
                volatileCart.setProducts(products);
                return;
            }

            for (Product product : products) {
                if (products.contains(product)) {
                    volatileCart.getProducts().remove(product);
                }
                volatileCart.getProducts().add(product);
            }
        }
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable Integer id) {
        if (volatileCart.getId().equals(id)) {
            volatileCart = null;
        }
    }

    @Scheduled(fixedDelay = 600000)
    private void deleteVolatileCart() {
        volatileCart = null;
    }
}
