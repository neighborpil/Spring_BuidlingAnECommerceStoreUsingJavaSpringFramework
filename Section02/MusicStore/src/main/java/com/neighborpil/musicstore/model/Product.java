package com.neighborpil.musicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -3490592717069664197L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @NotEmpty(message = "The product name must not be null.")
    private String productName;
    private String productCategory;
    private String productDescription;
    @Min(value = 0, message = "Product price must not be less than zero.")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less than zero.")
    private int unitInStock;
    private String productManufacturer;
    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;
}
