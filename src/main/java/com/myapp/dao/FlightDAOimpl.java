package com.myapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Flight;

public class FlightDAOimpl implements FlightDao {

	private Session session;
	public FlightDAOimpl(Session session) {
		super();
		this.session = session;
	}

	
	@Override
	public Flight save(Flight flight) {
		// TODO Auto-generated method stub
		//bifercation
		Transaction transaction =session.beginTransaction();
		try{
			session.save(flight);
			transaction.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		return flight;
	}

	@Override
	public Flight update(Flight flight) {
		// TODO Auto-generated method stub
		
		Transaction transaction =session.beginTransaction();
		try{
			session.update(flight);
			transaction.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		return flight;
		
	}

	@Override
	public List<Flight> findAll() {
		// TODO Auto-generated method stub
        return session.createQuery("from Flight").getResultList();//hibernate query lang

	}

	@Override
	public Flight findById(Long id) {
		// TODO Auto-generated method stub
		return session.find(Flight.class, id);// object type= class
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
          Flight flight = session.find(Flight.class, id);
          Transaction trxn = session.beginTransaction();
          try{
          session.remove(flight);
          trxn.commit();
          }
          catch(Exception e)
          {
        	  trxn.rollback();
          }
          }
	}


