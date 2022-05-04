package com.neighborpil.musicstore.controller;

import com.neighborpil.musicstore.dao.CartDao;
import com.neighborpil.musicstore.dao.ProductDao;
import com.neighborpil.musicstore.model.Cart;
import com.neighborpil.musicstore.model.CartItem;
import com.neighborpil.musicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") int cartId) {
        return cartDao.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") int cartId, @RequestBody Cart cart) {
        cartDao.update(cartId, cart);
    }

    @RequestMapping(value = "{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") int cartId) {
        cartDao.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId, HttpServletRequest request) {
        int sessionId = request.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);

        if (cart == null) {
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product));
    }




}
