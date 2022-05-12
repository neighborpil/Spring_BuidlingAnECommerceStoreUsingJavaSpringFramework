package com.neighborpil.musicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 4713668066660611300L;

    @Id
    @GeneratedValue
    private int customerId;


    @NotEmpty(message = "The customer name must not be null.")
    private String billingame;

    @NotEmpty(message = "The customer email must not be null.")
    private String customerEmail;
    private String customerPhone;


    @NotEmpty(message = "The customer username must not be null.")
    private String username;

    @NotEmpty(message = "The customer password must not be null.")
    private String password;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

}
