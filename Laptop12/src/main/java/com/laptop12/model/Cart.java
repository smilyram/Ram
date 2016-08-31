package com.laptop12.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.*;
import javax.persistence.criteria.Fetch;

import org.hibernate.annotations.Cascade;
@Entity
public class Cart {
	@Id@GeneratedValue
	private int cartId;
	private  Double grandTotal;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
	@OneToMany(mappedBy ="cart", cascade=CascadeType.ALL,fetch= FetchType.EAGER)
	private List<CartItem> cartItem;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<CartItem> getCartitem() {
		return cartItem;
	}
	public void setCartitem(List<CartItem> cartitem) {
		this.cartItem = cartitem;
	}
	

}
