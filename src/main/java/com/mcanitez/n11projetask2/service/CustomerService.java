package com.mcanitez.n11projetask2.service;

import com.mcanitez.n11projetask2.entity.Customer;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final List<Customer> customers;



    public CustomerService(List<Customer> customers) {
        this.customers = customers;

    }

    public List<Customer> getAllCustomers(){
        return customers;
    }

    public void createCustomer(String name, String sector){
        customers.add(new Customer(name,sector));
    }

    public List<Customer> getCustomersWithNameContainingC(){
        return customers.stream().filter(customer -> customer.getName().contains("C"))
                .collect(Collectors.toList());
    }
}
