package com.laptop12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop12.dao.CartItemDao;
import com.laptop12.model.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemDao cartItemDao;
	public void addItemToCart(CartItem cartitem) {
		cartItemDao.addItemToCart(cartitem);
		
	}

}
