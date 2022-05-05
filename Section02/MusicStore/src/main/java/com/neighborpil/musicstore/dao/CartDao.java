package com.neighborpil.musicstore.dao;


import com.neighborpil.musicstore.model.Cart;

public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
