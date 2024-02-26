package com.mcanitez.n11projetask2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {


    private final String name;
    private final String sector;


    public Customer(String name, String sector) {
        this.name = name;
        this.sector = sector;
    }

}
