package com.myapp.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory()
	{
		if(factory==null)
		{
			factory=Persistence.createEntityManagerFactory("PERSISTENCE");
		}
		return factory;
	}
	public static void shutDown()
	{
		if(factory!=null)
		{
			factory.close();
		}
	}

}
