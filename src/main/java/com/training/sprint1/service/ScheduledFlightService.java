package com.training.sprint1.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Airport;
import com.training.sprint1.entities.Flight;
import com.training.sprint1.entities.ScheduledFlight;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.repository.IScheduledFlightRepository;


@Service
@Transactional
public class ScheduledFlightService implements IScheduledFlightService{
	
	@Autowired
	private IScheduledFlightRepository flightRepository;

	@Override
	public ScheduledFlight addFlightSchedule(ScheduledFlight flight) {
		
		return flightRepository.save(flight);
	}

	@Override
	public List<ScheduledFlight> viewFlightSchedule(Long flightno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduledFlight removeFlightSchedule(Long scheduledFlightId) throws FlightNotFoundException {
		ScheduledFlight deletedScheduledFlight = flightRepository.findById(scheduledFlightId).orElseThrow(FlightNotFoundException :: new);
		flightRepository.deleteById(scheduledFlightId);
		return deletedScheduledFlight;
	}

	@Override
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight) throws FlightNotFoundException {
		ScheduledFlight updatedScheduledFlight = flightRepository.findById(flight.getScheduledFlightIdLong()).orElseThrow(FlightNotFoundException :: new);
		updatedScheduledFlight.setAvailableSeats(flight.getAvailableSeats());
		updatedScheduledFlight.setFlight(flight.getFlight());
		updatedScheduledFlight.setSchedule(flight.getSchedule());
		
		return flightRepository.save(updatedScheduledFlight);
	}

	@Override
	public List<ScheduledFlight> viewAllScheduledFlights() {
		
		return flightRepository.findAll();
	}

	
	@Override
	public List<ScheduledFlight> viewAllScheduledFlightsByDate(LocalDate date) {
		
		return flightRepository.findByScheduleScheduleDate(date);
	}

	@Override
	public List<ScheduledFlight> viewAllScheduledFlightsByAriportAndDate(Airport sourceAirport,
			Airport destenationAirport, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	

}