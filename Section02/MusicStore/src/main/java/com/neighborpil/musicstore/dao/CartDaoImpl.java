package com.neighborpil.musicstore.dao;

import com.neighborpil.musicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {

    private Map<Integer, Cart> listOfCarts;

    public CartDaoImpl() {
        listOfCarts = new HashMap<>();
    }

    @Override
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with the given id already exists." + cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    @Override
    public Cart read(int cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(int cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException("Cannot update a cart. The cart with the given id doesn't exist." + cartId);
        }

        listOfCarts.put(cartId, cart);
    }

    @Override
    public void delete(int cartId) {

        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException("Cannot delete a cart. The cart with the given id doesn't exist." + cartId);
        }

        listOfCarts.remove(cartId);
    }
}
