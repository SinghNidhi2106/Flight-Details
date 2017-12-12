package com.myapp.dao;

import java.util.List;

import com.myapp.model.Flight;

public interface FlightDao {
	Flight save(Flight flight);
	Flight update(Flight flight);
	List<Flight> findAll();
	Flight findById(Long id);
	
	void remove(Long id);

}
