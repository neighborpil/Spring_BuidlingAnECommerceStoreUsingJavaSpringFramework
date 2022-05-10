package com.neighborpil.musicstore.service.impl;

import com.neighborpil.musicstore.dao.CartDao;
import com.neighborpil.musicstore.model.Cart;
import com.neighborpil.musicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void update(Cart cart) {

        cartDao.update(cart);

    }
}
