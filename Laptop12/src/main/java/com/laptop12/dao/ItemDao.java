package com.laptop12.dao;

import java.util.List;

import com.laptop12.model.Item;



public interface ItemDao {
	void addproduct(Item item);
	List<Item> viewItem();
	void deleteItem(int id);
	Item getItemById(int id);
	void updateItem(Item item);
}
