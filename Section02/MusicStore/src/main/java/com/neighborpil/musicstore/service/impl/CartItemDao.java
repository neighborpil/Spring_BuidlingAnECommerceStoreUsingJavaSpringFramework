package com.neighborpil.musicstore.service.impl;

import com.neighborpil.musicstore.model.Cart;
import com.neighborpil.musicstore.model.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItem(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
