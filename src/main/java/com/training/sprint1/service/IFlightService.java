package com.training.sprint1.service;



import java.util.List;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.exception.FlightNotFoundException;


public interface IFlightService {

	public Flight addFlight(Flight flight);
	public Flight viewFlight(Long flightId) throws FlightNotFoundException;
	public List<Flight> viewAllFlights();
	public List<Flight> removeFlight(Long flightno);
	public Flight updateFlight(Flight flight);
}
