package com.neighborpil.musicstore.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cart {

    private String cartId;
    private Map<String, CartItem> cartItems;
    private double grandTotal;

    public Cart() {
        cartItems = new HashMap<>();
        grandTotal = 0;
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public void addCartItem(CartItem item) {
        String productId = item.getProduct().getProductId();

        if (cartItems.containsKey(productId)) {
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId, item);
        }


        updateGrandTotal();
    }

    private void updateGrandTotal() {

        grandTotal = 0;
        for (CartItem item : cartItems.values()) {
            grandTotal = grandTotal + (item.getTotalPrice() * item.getQuantity());
        }
    }

    public void removeCartItem(CartItem item) {
        String productId = item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }
}
