package com.myapp.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

/*Utility class to bootstrap hibernate, initialize the sessionFactory and get the session */

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;

	private static StandardServiceRegistry registry;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// create registry
			registry = new StandardServiceRegistryBuilder().configure().build();

			// create metadata
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();

		}

		return sessionFactory;
	}

	public static Session getSession() {
		Session session = null;
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
	
	public static void shutdown()
	{
		if(registry!=null)
		{
			StandardServiceRegistryBuilder.destroy(registry);
			
		}
	}

}
