package com.laptop12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.laptop12.dao.CustomerDao;
import com.laptop12.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;
	public void  addCustomer(Customer customer){
		System.out.println("im in addcustomer in service class");
		customerDao.addCustomer(customer);
	}
	public List<Customer> viewCustomer() {
		List<Customer> list=customerDao.viewCustomer();
		return list;
	}
	@Override
	public Customer getCustomerByName(String name) {
		return customerDao.getCustomerByName(name);
		
	}
	
		
	

}
