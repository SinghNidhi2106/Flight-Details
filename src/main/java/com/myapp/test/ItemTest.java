package com.myapp.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.myapp.config.JPAUtil;
import com.myapp.model.Bid;
import com.myapp.model.Item;


public class ItemTest {

	public static void main(String[] args) {
		List<String> images = new ArrayList<>();
		//Set<String> images = new HashSet<>();
		images.add("Silver");
		images.add("Black");
		images.add("White");
		Set<Bid> bidds= new HashSet<>();
		
		Bid bid1= new Bid(45667.5);
		Bid bid2= new Bid(35667.5);
		Bid bid3= new Bid(46667.5);
		
		Item item = new Item("Laptop");
		bid1.setItem(item);
		bidds.add(bid1);
		bid2.setItem(item);
		bidds.add(bid2);
		bid3.setItem(item);
		bidds.add(bid3);
		
		//Item item = new Item("Laptop");
		//item.setImages(images);
		
		//item.setBids(bidds);
		
		EntityManager session = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction trxn = session.getTransaction();
		try{
			trxn.begin();
			session.persist(item);
			//session.find(Item.class, 18L).getImages().get(2));
			trxn.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			trxn.rollback();
		}
        JPAUtil.shutDown();
	}

}
