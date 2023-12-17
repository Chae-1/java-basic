package org.example.ch05.com.helloshop.order;

import org.example.ch05.com.helloshop.product.Product;
import org.example.ch05.com.helloshop.user.User;

public class Order {
    User user;
    Product product;

    public Order(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
