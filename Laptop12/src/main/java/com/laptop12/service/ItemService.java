package com.laptop12.service;

import java.util.List;

import com.laptop12.model.Item;



public interface ItemService {
	
	void addproduct(Item item);
	List<Item> viewItem();
	void deleteItem(int id);
	Item getItemById(int itemId);
	void updateItem(Item item);

}
