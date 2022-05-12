package com.neighborpil.musicstore.controller;

import com.neighborpil.musicstore.model.Cart;
import com.neighborpil.musicstore.model.Customer;
import com.neighborpil.musicstore.model.CustomerOrder;
import com.neighborpil.musicstore.service.CartService;
import com.neighborpil.musicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOrderController {

    @Autowired
    CartService cartService;

    @Autowired
    CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable(value = "cartId") int cartId) {
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cartId=" + cartId;
    }
}
