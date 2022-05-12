package com.neighborpil.musicstore.service.impl;

import com.neighborpil.musicstore.dao.CartItemDao;
import com.neighborpil.musicstore.model.Cart;
import com.neighborpil.musicstore.model.CartItem;
import com.neighborpil.musicstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);

    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItem(Cart cart) {
        cartItemDao.removeAllCartItem(cart);
    }

    @Override
    public CartItem getCartItemByProductId(int productId) {
        return cartItemDao.getCartItemByProductId(productId);
    }
}
