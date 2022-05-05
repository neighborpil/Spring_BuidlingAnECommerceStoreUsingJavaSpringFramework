package com.neighborpil.musicstore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = -1241650858476820143L;

    @Id
    @GeneratedValue
    private int customerOrderId;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shoppingAddressId")
    private ShoppingAddress shoppingAddress;

}
