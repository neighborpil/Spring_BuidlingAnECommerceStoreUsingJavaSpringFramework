package com.neighorpil.musicstore.model;

import lombok.Data;

@Data
public class Product {

    private String productId;
    private String productName;
    private String productCategory;
    private String productDescription;
    private double productPrice;
    private String productCondition;
    private String productStatus;
    private int unitInStock;
    private String productManufacturer;
}
