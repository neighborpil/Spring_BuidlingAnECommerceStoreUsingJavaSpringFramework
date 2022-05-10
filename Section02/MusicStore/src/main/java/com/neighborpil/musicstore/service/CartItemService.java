package com.neighborpil.musicstore.service;

import com.neighborpil.musicstore.model.Cart;
import com.neighborpil.musicstore.model.CartItem;
import org.springframework.stereotype.Controller;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItem(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
