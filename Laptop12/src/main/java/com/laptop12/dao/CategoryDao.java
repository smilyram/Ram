package com.laptop12.dao;

import java.util.List;

import com.laptop12.model.Item;

public interface CategoryDao {

	List<Item> getItemByCategory(String category);
}
