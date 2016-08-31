package com.laptop12.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptop12.model.CartItem;

@Repository
public class CartItemDaoImpl implements CartItemDao{

	
	@Autowired
	SessionFactory sessionFactory;
	public void addItemToCart(CartItem cartitem) {
		System.out.println("im in add product/item repository");
		Session session=sessionFactory.getCurrentSession();
		Transaction trasaction=session.beginTransaction();
		session.save(cartitem);
		trasaction.commit();
		System.out.println("Done add products to cart");
		
	}

}
