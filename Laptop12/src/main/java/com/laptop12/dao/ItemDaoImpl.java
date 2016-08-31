package com.laptop12.dao;

import java.util.List;

import javax.persistence.AssociationOverride;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptop12.model.Item;


@Repository
public class ItemDaoImpl implements ItemDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public void addproduct(Item item) 
	{
		System.out.println("im in add product/item repository");
		Session session=sessionFactory.getCurrentSession();
		Transaction trasaction=session.beginTransaction();
		session.save(item);
		trasaction.commit();
		System.out.println("Done the saving products");
}


	@SuppressWarnings("unchecked")
	public List<Item> viewItem() {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		List<Item> list=session.createCriteria(Item.class).list();
		return list;
	}

@Override
	public void deleteItem(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Item item=session.get(Item.class,new Integer(id));
	
		session.delete(item);
		transaction.commit();
		System.out.println("deleted:"+item.getItemName());
		
	}


@Override
public Item getItemById(int id) {
	Session session=sessionFactory.getCurrentSession();
	Transaction transaction=session.beginTransaction();
	Item item=session.load(Item.class,new Integer(id));
	return item;
	
}


@Override
public void updateItem(Item item) {
	Session session=sessionFactory.getCurrentSession();
	Transaction transaction=session.beginTransaction();
	session.update(item);
	transaction.commit();
	System.out.println("updated");
	
}





}
