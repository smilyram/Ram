package com.laptop12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.laptop12.model.Cart;
import com.laptop12.model.CartItem;
import com.laptop12.model.Customer;
import com.laptop12.model.Item;
import com.laptop12.service.CartItemService;
import com.laptop12.service.CustomerService;
import com.laptop12.service.ItemService;

@Controller
public class CartController 
{
	@Autowired
	ItemService itemService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CustomerService customerService;
	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam("id") String id)
	{
		System.out.println("cart controller addToCart = "+id);
		String loggedInUserName=SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("loggedInUserName = "+loggedInUserName);
		Customer customer=customerService.getCustomerByName(loggedInUserName);
		System.out.println("after getting customer ="+customer);
		Cart cart=customer.getCart();
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		Item item=itemService.getItemById(Integer.parseInt(id));
		cartItem.setQuantity(1);
		cartItem.setItem(item);
		cartItem.setTotalAmount(item.getPrice());
		cartItemService.addItemToCart(cartItem);
		return "redirect:/Customer";
	}
}
