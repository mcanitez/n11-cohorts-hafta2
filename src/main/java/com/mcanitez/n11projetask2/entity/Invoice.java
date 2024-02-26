package com.mcanitez.n11projetask2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {

    private final   Customer customer;
    private final double amount;
    private final String month;

    public Invoice(Customer customer, double amount, String month) {
        this.customer = customer;
        this.amount = amount;
        this.month = month;
    }
}
