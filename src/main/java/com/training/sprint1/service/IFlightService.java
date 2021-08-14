package com.training.sprint1.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.exception.FlightNotFoundException;

@Service
public interface IFlightService {

	public Flight addFlight(Flight flight);
	public Flight viewFlight(Long flightId);
	public List<Flight> viewAllFlights();
	public Flight removeFlight(Long flightno);
	public Flight updateFlight(Flight flight);
}
