package com.myapp.test;

import java.util.Date;

import com.myapp.config.JPAUtil;
import com.myapp.dao.FlightDAOJPAImpl;
import com.myapp.dao.FlightDao;
import com.myapp.model.Flight;

public class FlightDAOJpaTest {
	public static void main(String[] args)
	{
		FlightDao dao= new FlightDAOJPAImpl(JPAUtil.getEntityManagerFactory().createEntityManager());
		
		for(int i=1;i<4;i++)
		{
			Flight flight= dao.save(new Flight("Indigo",new Date(), new Date(),"ChatrapatiIA"+i,"KIA"+i,1000+i));
			
		}
	}

}
