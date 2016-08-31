package com.laptop12.service;

import java.util.List;

import com.laptop12.model.Item;

public interface CategoryService {
	
	List<Item> getItemByCategory(String category);
}
