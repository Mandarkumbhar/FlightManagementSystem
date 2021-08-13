package com.training.sprint1.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Airport;
import com.training.sprint1.entities.Flight;
import com.training.sprint1.entities.ScheduledFlight;
import com.training.sprint1.exception.FlightNotFoundException;

@Service
public interface IScheduledFlightService {
	public ScheduledFlight addFlightSchedule(ScheduledFlight flight);
	public List<ScheduledFlight> viewFlightSchedule(Long flightno);
	public ScheduledFlight removeFlightSchedule(Long scheduledFlightId) throws FlightNotFoundException;
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight) throws FlightNotFoundException;
	public List<ScheduledFlight> viewAllScheduledFlights();
	public List<ScheduledFlight> viewAllScheduledFlightsByAriportAndDate(Airport sourceAirport,Airport destenationAirport,LocalDate date);
	public List<ScheduledFlight> viewAllScheduledFlightsByDate(LocalDate date);

}
