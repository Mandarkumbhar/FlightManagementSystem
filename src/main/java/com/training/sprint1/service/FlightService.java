package com.training.sprint1.service;


import java.util.List;
import java.util.Optional;

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
		Optional<Flight> flight = repo.findById(flightno);
		return flight.get();
	}

	@Override
	public List<Flight> viewAllFlights() {
		return repo.findAll();
	}

	@Override
	public List<Flight> removeFlight(Long flightno) { 
		repo.deleteById(flightno);
		return repo.findAll();
	}

	@Override
	public Flight updateFlight(Flight flight) {
		Flight f1 = null;
		try {
			f1 = repo.findById(flight.getFlightId()).orElseThrow(FlightNotFoundException::new);
		}catch(FlightNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		}
		f1.setCarrierName(flight.getCarrierName());
		f1.setFlightModel(flight.getFlightModel());
		f1.setSeatCapacity(flight.getSeatCapacity());
		
		Flight f2 = repo.save(f1);
		return f2;	
	}

}

