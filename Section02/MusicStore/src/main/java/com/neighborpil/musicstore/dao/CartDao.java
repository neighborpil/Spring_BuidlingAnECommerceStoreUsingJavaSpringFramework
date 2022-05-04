package com.neighborpil.musicstore.dao;


import com.neighborpil.musicstore.model.Cart;

public interface CartDao {

    Cart create(Cart cart);

    Cart read(int cartId);

    void update(int cartId, Cart cart);

    void delete(int cartId);
}
