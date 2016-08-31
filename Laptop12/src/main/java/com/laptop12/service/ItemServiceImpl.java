package com.laptop12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop12.dao.ItemDao;
import com.laptop12.model.Customer;
import com.laptop12.model.Item;


@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDao itemDao;

	@Override
	public void addproduct(Item item) {
	
		itemDao.addproduct(item);
	}


	@Override
	public void deleteItem(int id) {
		itemDao.deleteItem(id);
		
	}
	
	public List<Item> viewItem() {
    List<Item> list=itemDao.viewItem();
		return list;
	}


	@Override
	public Item getItemById(int id) {
		return itemDao.getItemById(id);
	}


	@Override
	public void updateItem(Item item) {
		itemDao.updateItem(item);
		
	}

}	
