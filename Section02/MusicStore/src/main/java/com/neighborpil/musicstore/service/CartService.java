package com.neighborpil.musicstore.service;

import com.neighborpil.musicstore.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
