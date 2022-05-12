package com.neighborpil.musicstore.dao.impl;

import com.neighborpil.musicstore.dao.CartDao;
import com.neighborpil.musicstore.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();

        return (Cart) session.get(Cart.class, cartId);
    }

    @Override
    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException(cartId + "");
        }

        update(cart);
        return cart;
    }

    @Override
    public void update(Cart cart) {

        int cartId = cart.getCartId();
        // TODO: do it later
//        Session session = sessionFactory.getCurrentSession();

    }
}
