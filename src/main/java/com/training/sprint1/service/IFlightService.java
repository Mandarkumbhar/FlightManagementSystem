package com.training.sprint1.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.exception.FlightNotFoundException;

@Service
public interface IFlightService {

	public Flight addFlight(Flight flight);
	public Flight viewFlight(Long flightId) throws FlightNotFoundException;
	public List<Flight> viewAllFlights() throws FlightNotFoundException;
	public Flight removeFlight(Long flightno) throws FlightNotFoundException;
	public Flight updateFlight(Flight flight) throws FlightNotFoundException;
}
