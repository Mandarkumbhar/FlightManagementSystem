package com.training.sprint1.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.training.sprint1.entities.Airport;
import com.training.sprint1.entities.Flight;
import com.training.sprint1.entities.ScheduledFlight;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.service.IAirportService;
import com.training.sprint1.service.IFlightService;
import com.training.sprint1.service.ScheduledFlightService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IFlightService flightService;
	@Autowired
	private IAirportService airportService;
	
	private ScheduledFlightService scheduledFlightService;
	
	
	@GetMapping("/airports")
	public ResponseEntity<List<Airport>> viewAirport() {
		List<Airport> airport = airportService.viewAirport();
		if(airport.isEmpty()) {
			return new ResponseEntity("Airport not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Airport>>(airport, HttpStatus.OK);
	}
	
	
	@GetMapping("/airports/{airportId}")
	public ResponseEntity<Airport> viewAirportById(@PathVariable Long airportId){
		Airport airport = airportService.viewAirportById(airportId);
		if(airport == null) {
			return new ResponseEntity("Airport not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
	}
	
	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> viewAllFlights() {
		try {
		return new ResponseEntity<List<Flight>>(flightService.viewAllFlights(), HttpStatus.OK);
		} catch (FlightNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Flights to display");
		}
	}
	
	@GetMapping("/flights/{flightId}")
	public ResponseEntity<Flight> viewFlight(@PathVariable Long flightId) throws FlightNotFoundException {
		try {
			return new ResponseEntity<Flight>(flightService.viewFlight(flightId), HttpStatus.OK);
		} catch (FlightNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight with this Id Not Found");
		}
	}
	
	@PostMapping("/flights")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight f1) {
		Flight flight = flightService.addFlight(f1);
		return new ResponseEntity<Flight>(flight, HttpStatus.CREATED);
	}
	
	@PutMapping("/flights")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight f1) {
		try {
			return new ResponseEntity<Flight>(flightService.updateFlight(f1), HttpStatus.OK);
		}catch(FlightNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight with this Id Not Found");
		}
		
	}
	
	@DeleteMapping("/flights/{flightId}")
	public ResponseEntity <Flight> removeFlight(@PathVariable Long flightId) {
		try {
			return new ResponseEntity<Flight>(flightService.removeFlight(flightId), HttpStatus.OK);
		}catch(FlightNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight with this Id Not Found");
		}
		
	}
	
	@GetMapping("/scheduledFlights")
	public ResponseEntity<List<ScheduledFlight>> ListAllScheduledFlights(){
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewAllScheduledFlights(),HttpStatus.OK);
	}
	
	@PostMapping("/scheduledFlights")
	public ResponseEntity<ScheduledFlight> addScheduledFlight(@RequestBody ScheduledFlight f1) {
		ScheduledFlight scheduledFlight = scheduledFlightService.addFlightSchedule(f1);
		return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.CREATED);
	}
	
	@GetMapping("/scheduledFlightsByDate")
	public ResponseEntity<List<ScheduledFlight>> ListAllScheduledFlightsByDate(@RequestParam("date") LocalDate date){
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewAllScheduledFlightsByDate(date),HttpStatus.OK);
	}
}
