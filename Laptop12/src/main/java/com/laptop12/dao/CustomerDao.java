package com.laptop12.dao;




import java.util.List;

import com.laptop12.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer customer);
	List<Customer> viewCustomer();
	Customer getCustomerByName(String name);

}
