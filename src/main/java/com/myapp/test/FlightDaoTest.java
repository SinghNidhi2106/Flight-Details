package com.myapp.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.myapp.config.HibernateSessionFactory;
import com.myapp.dao.FlightDAOimpl;
import com.myapp.dao.FlightDao;
import com.myapp.model.Flight;

public class FlightDaoTest {
	public static void main(String[] args)
	{
		HibernateSessionFactory.getSessionFactory();// to get any session object through session FACTORY
		FlightDao dao= new FlightDAOimpl(HibernateSessionFactory.getSession());
		for(int i=1;i<4;i++)
		{
	    Flight flight= dao.save(new Flight("AirIndia",new Date(), new Date(),"KIA"+i,"IndiragandhiInternationalAirport"+i,1000+i));
		}
		//Flight flight= dao.findById(1L);
		//dao.remove(2L);
		//flight.setToAirport("T1");
		//dao.update(flight);
	  // System.out.println(flight);
		
		/*List<Flight> list = dao.findAll();
		for(Flight f:list)
		{
			System.out.println(f);
		}*/
		
		Transaction trxn = HibernateSessionFactory.getSession().beginTransaction();
		Flight flight = dao.findById(8L);
		try{
			flight.setToAirport("T2");
			HibernateSessionFactory.getSession().update(flight);
			trxn.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    HibernateSessionFactory.shutdown();
	}

}
