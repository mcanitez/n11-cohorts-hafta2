package com.mcanitez.n11projetask2.service;

import com.mcanitez.n11projetask2.entity.Invoice;


import java.util.*;
import java.util.stream.Collectors;

public class InvoiceService {

    private final List<Invoice> invoices;

    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getAllInvoice(){
        return invoices;
    }

    public double getTotalAmountOfInvoicesForJune(List<Invoice> invoices){
       return invoices.stream().filter(invoice -> invoice.getMonth().equalsIgnoreCase("June"))
               .mapToDouble(Invoice::getAmount)
               .sum();
    }

    public List<Invoice> getAllInvoices(List<Invoice> invoices){
        return invoices;
    }

    public List<Invoice> getInvoicesOverThreshold (List<Invoice> invoices, double threshold){
        return invoices.stream().filter(invoice -> invoice.getAmount() > threshold)
                .collect(Collectors.toList());
    }

    public List<String> getCustomersWithInvoicesBelowThreshold(List<Invoice> invoices, double threshold) {
        Set<String> customerNames = new HashSet<>();
        invoices.forEach(invoice -> {
            if (invoice.getAmount() < threshold) {
                customerNames.add(invoice.getCustomer().getName());
            }
        });
        return new ArrayList<>(customerNames);
}
    public Set<String> getCustomerSectorsWithAverageInvoiceBelowThreshold(List<Invoice> invoices, String month, double threshold) {
        Map<String, List<Double>> sectorToAmountMap = new HashMap<>();
        invoices.stream()
                .filter(invoice -> invoice.getMonth().equalsIgnoreCase(month))
                .forEach(invoice -> {
                    String sector = invoice.getCustomer().getSector();
                    double amount = invoice.getAmount();
                    sectorToAmountMap.computeIfAbsent(sector, k -> new ArrayList<>()).add(amount);
                });

        Set<String> result = new HashSet<>();
        sectorToAmountMap.forEach((sector, amounts) -> {
            double average = amounts.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            if (average < threshold) {
                result.add(sector);
            }
        });
        return result;
    }
}
