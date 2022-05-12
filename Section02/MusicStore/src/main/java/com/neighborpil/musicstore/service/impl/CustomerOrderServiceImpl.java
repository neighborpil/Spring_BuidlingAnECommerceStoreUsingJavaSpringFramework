package com.neighborpil.musicstore.service.impl;

import com.neighborpil.musicstore.dao.CustomerOrderDao;
import com.neighborpil.musicstore.model.Cart;
import com.neighborpil.musicstore.model.CartItem;
import com.neighborpil.musicstore.model.CustomerOrder;
import com.neighborpil.musicstore.service.CartService;
import com.neighborpil.musicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderDao customerOrderDao;

    @Autowired
    CartService cartService;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    @Override
    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            grandTotal += cartItem.getTotalPrice();
        }

        return grandTotal;
    }
}
