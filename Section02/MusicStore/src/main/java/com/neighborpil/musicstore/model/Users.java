package com.neighborpil.musicstore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Users {

    @Id
    @GeneratedValue
    private int usersId;
    private String username;
    private String password;
    private boolean enabled;
    private int customerId;
}
