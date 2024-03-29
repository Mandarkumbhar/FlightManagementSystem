package com.training.sprint1.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.training.sprint1.entities.ScheduledFlight;
import com.training.sprint1.exception.FlightNotFoundException;

@Service
public interface IScheduledFlightService {
	public ScheduledFlight addFlightSchedule(ScheduledFlight flight);
	public ScheduledFlight viewFlightSchedule(Long flightno) throws FlightNotFoundException;
	public ScheduledFlight removeFlightSchedule(Long scheduledFlightId) throws FlightNotFoundException;
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight) throws FlightNotFoundException;
	public ScheduledFlight updateFlightScheduleStatus(ScheduledFlight flight) throws FlightNotFoundException;
	public List<ScheduledFlight> viewAllScheduledFlights();

	public List<ScheduledFlight> viewAllScheduledFlightsByDate(LocalDate date) throws FlightNotFoundException;
	public List<ScheduledFlight> viewAllScheduledFlightsByAriportAndDate(Long sourceAirportId, Long destenationAirportId,LocalDate date) throws FlightNotFoundException;

}
