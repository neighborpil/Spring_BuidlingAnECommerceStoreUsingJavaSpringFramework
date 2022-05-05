package com.neighborpil.musicstore.dao;

import com.neighborpil.musicstore.model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProduct();

    void deleteProduct(String id);
}
