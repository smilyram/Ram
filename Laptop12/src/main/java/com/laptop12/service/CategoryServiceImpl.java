package com.laptop12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop12.dao.CategoryDao;
import com.laptop12.model.Item;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;


	public List<Item> getItemByCategory(String category) {
		
		return categoryDao.getItemByCategory(category);
	}
	
	

	

	

}
