package com.neighborpil.musicstore.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cart {

    private int cartId;
    private Map<Integer, CartItem> cartItems;
    private double grandTotal;

    public Cart() {
        cartItems = new HashMap<>();
        grandTotal = 0;
    }

    public Cart(int cartId) {
        this();
        this.cartId = cartId;
    }

    public void addCartItem(CartItem item) {
        int productId = item.getProduct().getProductId();

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
            grandTotal = grandTotal + item.getTotalPrice();
        }
    }

    public void removeCartItem(CartItem item) {
        int productId = item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }
}
