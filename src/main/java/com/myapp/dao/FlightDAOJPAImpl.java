package com.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.myapp.model.Flight;

public class FlightDAOJPAImpl implements FlightDao {
	
	private EntityManager entityManager;
	
	

	public FlightDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public Flight save(Flight flight) {
        // TODO Auto-generated method stub
        EntityTransaction tnxn=entityManager.getTransaction();
        try{
               tnxn.begin();
               entityManager.persist(flight);
               tnxn.commit();
               
        }catch(Exception e){
               e.getStackTrace();
               tnxn.rollback();
        }
        return flight;
 }


	@Override
	public Flight update(Flight flight) {
		EntityTransaction trxn = entityManager.getTransaction();
		try{
			trxn.begin();
			entityManager.merge(flight);
			trxn.commit();
		}
		catch(Exception e)
		{
			trxn.rollback();
		}
		return flight;
	}

	@Override
	public List<Flight> findAll() { 
			return entityManager.createQuery("from Flight").getResultList(); 
			 

	}

	@Override
	public Flight findById(Long id) {
		return entityManager.find(Flight.class, id);
	}

	@Override
	public void remove(Long id) {
		EntityTransaction trxn=entityManager.getTransaction();
		try{
			trxn.begin();
			entityManager.remove(entityManager.find(Flight.class,id));
			trxn.commit();
		}catch(Exception e)
		{
			e.getStackTrace();
			trxn.rollback();
			
		} 

	}

}
