package com.neighborpil.musicstore.model;

import lombok.Data;

@Data
public class CartItem {

    private Product product;
    private int quantity;
    private double totalPrice;

    public CartItem() {
    }

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getProductPrice();
    }
}