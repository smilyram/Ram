package com.laptop12.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptop12.model.Cart;
import com.laptop12.model.Customer;
import com.laptop12.model.Item;
import com.laptop12.model.UserRole;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	//it will create session factory object which was created in appl-contx
	@Autowired
	SessionFactory sessionFactory;
	//saving the customer
	public void addCustomer(Customer customer) 
	{
		System.out.println("im in add customer repository");
		Session session=sessionFactory.getCurrentSession();
		Transaction trasaction=session.beginTransaction();
		
		UserRole userRole=new UserRole();
		customer.setEnabled(true);
		session.save(customer);
		
		userRole.setAuthority("ROLE_USER");
		userRole.setId(customer.getCustomerId());
		session.save(userRole);
		Cart cart=new Cart();
		customer.setCart(cart);
		trasaction.commit();
		System.out.println("Done the saving cusomer");
	
	}
	@Override
	public List<Customer> viewCustomer() {
		Session session=sessionFactory.getCurrentSession();
		Transaction trasaction=session.beginTransaction();
		List<Customer> list=session.createCriteria(Customer.class).list();
		return list;
	}
	@Override
	public Customer getCustomerByName(String name) {
		Session session=sessionFactory.getCurrentSession();
		Transaction trasaction=session.beginTransaction();
		Customer customer=(Customer) session.createCriteria(Customer.class).add(Restrictions.like("name", name)).uniqueResult();
		trasaction.commit();
		return customer;
	}
	
	
	
}
