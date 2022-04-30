package com.neighborpil.musicstore.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="test")
public class Test {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String name;

}
