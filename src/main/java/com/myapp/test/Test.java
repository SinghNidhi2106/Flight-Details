package com.myapp.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.config.HibernateSessionFactory;
import com.myapp.model.Flight;

public class Test {

	public static void main(String[] args) {
		


		HibernateSessionFactory.getSessionFactory();
		
		Session  session=HibernateSessionFactory.getSession();
		
		Flight flight=session.find(Flight.class, 8L);
		Transaction trxn=session.beginTransaction();
		try {
			
			flight.setAirlines("dljdkjd");
			trxn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			trxn.rollback();
		}
		

	}

}
