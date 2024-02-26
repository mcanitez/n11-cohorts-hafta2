package com.mcanitez.n11projetask2;

import com.mcanitez.n11projetask2.entity.Customer;
import com.mcanitez.n11projetask2.entity.Invoice;
import com.mcanitez.n11projetask2.service.CustomerService;
import com.mcanitez.n11projetask2.service.InvoiceService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class N11ProjeTask2Application {

	public static void main(String[] args) {



		Customer customer1 = new Customer("Mustafa", "Software");
		Customer customer2 = new Customer("Canberk", "Food");
		Customer customer3 = new Customer("Mehmet", "Health");
		Customer customer4 = new Customer("Cemal", "Real Estate");
		List<Customer> customers = Arrays.asList(customer1, customer2,customer3,customer4);

		Invoice invoice1 = new Invoice(customer1, 1200.0, "June");
		Invoice invoice2 = new Invoice(customer2, 1800.0, "July");
		Invoice invoice3 = new Invoice(customer1, 900.0, "June");
		Invoice invoice4 = new Invoice(customer3, 300.0, "June");
		Invoice invoice5 = new Invoice(customer2, 3000.0, "October");
		Invoice invoice6 = new Invoice(customer3, 2500.0, "December");
		Invoice invoice7 = new Invoice(customer4, 10000.0, "February");
		Invoice invoice8 = new Invoice(customer4, 550.0, "June");
		List<Invoice> invoices = Arrays.asList(invoice1, invoice2, invoice3,invoice4,invoice5,invoice6,invoice7,invoice8);


		CustomerService customerService = new CustomerService(new ArrayList<>(customers));
		InvoiceService invoiceService = new InvoiceService(new ArrayList<>(invoices));


		System.out.println("All Customers:");
		customerService.getAllCustomers().forEach(customer -> System.out.println(customer.getName()));

		System.out.println("**************************************************************************");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the name of the new customer:");
		String newCustomerName = scanner.nextLine();


		customerService.createCustomer(newCustomerName, "Software");
		System.out.println("\nNew Customer Added: " + newCustomerName);


		System.out.println("**************************************************************************");
		System.out.println("\nCustomers with 'C' in their name:");
		customerService.getCustomersWithNameContainingC().forEach(customer -> System.out.println(customer.getName()));

		System.out.println("**************************************************************************");
		double totalAmountForJune = invoiceService.getTotalAmountOfInvoicesForJune(invoices);
		System.out.println("\nTotal Amount of Invoices for June: " + totalAmountForJune);

		System.out.println("**************************************************************************");
		System.out.println("\nAll Invoices:");
		invoiceService.getAllInvoices(invoices).forEach(invoice -> System.out.println("Customer: " + invoice.getCustomer().getName() + ", Amount: " + invoice.getAmount()));

		System.out.println("**************************************************************************");
		System.out.println("\nInvoices above 1500 TL:");
		invoiceService.getInvoicesOverThreshold(invoices, 1500).forEach(invoice -> System.out.println("Customer: " + invoice.getCustomer().getName() + ", Amount: " + invoice.getAmount()));

		System.out.println("**************************************************************************");
		System.out.println("\nCustomers with Invoices below 500 TL:");
		invoiceService.getCustomersWithInvoicesBelowThreshold(invoices, 500).forEach(System.out::println);

		System.out.println("**************************************************************************");
		System.out.println("\nCustomer Sectors with Average Invoice below 750 TL for June:");
		invoiceService.getCustomerSectorsWithAverageInvoiceBelowThreshold(invoices, "June", 750).forEach(System.out::println);
	}
}


