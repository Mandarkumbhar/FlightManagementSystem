package com.training.sprint1.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.repository.IFlightRepository;

@Service
@Transactional
public class FlightService implements IFlightService{
	@Autowired
	private IFlightRepository repo;
	
	@Override
	public Flight addFlight(Flight flight) {
		Flight f1 = repo.save(flight);
		return f1;
	}

	@Override
	public Flight viewFlight(Long flightno) throws FlightNotFoundException {
		Flight f1 = null;
		f1 = repo.findById(flightno).orElseThrow(FlightNotFoundException::new);
		return f1;
	}

	@Override
	public List<Flight> viewAllFlights() throws FlightNotFoundException {
		List<Flight> flights = new ArrayList<>();
		flights = repo.findAll();
		if(flights.isEmpty()) {
			throw new FlightNotFoundException("No Flights to display");
		}
		return flights;
	}

	@Override
	public Flight removeFlight(Long flightno) throws FlightNotFoundException { 
		Flight f1 = null;
		f1 = repo.findById(flightno).orElseThrow(FlightNotFoundException::new);
		repo.deleteById(flightno);
		return f1;
	}

	@Override
	public Flight updateFlight(Flight flight) throws FlightNotFoundException {
		Flight f1 = null;
		f1 = repo.findById(flight.getFlightId()).orElseThrow(FlightNotFoundException::new);
		f1.setCarrierName(flight.getCarrierName());
		f1.setFlightModel(flight.getFlightModel());
		f1.setSeatCapacity(flight.getSeatCapacity());
		
		Flight f2 = repo.save(f1);
		return f2;	
	}

}

