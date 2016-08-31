package com.laptop12.service;

import java.util.List;

import com.laptop12.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	List<Customer> viewCustomer();
	Customer getCustomerByName(String name);
}
