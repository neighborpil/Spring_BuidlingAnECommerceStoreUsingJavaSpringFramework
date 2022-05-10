package com.neighborpil.musicstore.controller;

import com.neighborpil.musicstore.model.Product;
import com.neighborpil.musicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable("productId") int productId, @RequestParam(value = "admin", required = false) String admin, Model model) throws IOException {

        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        if (admin != null) {
            model.addAttribute("isAdmin", true);
        }

        return "viewProduct";
    }
}
