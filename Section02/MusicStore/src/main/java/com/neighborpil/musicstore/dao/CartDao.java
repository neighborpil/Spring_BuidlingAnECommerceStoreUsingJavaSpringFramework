package com.neighborpil.musicstore.dao;


import com.neighborpil.musicstore.model.Cart;

public interface CartDao {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
