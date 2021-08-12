package com.training.sprint1.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.service.IFlightService;

@RestController
@RequestMapping("/rest/api")
public class AdminController {
	
	@Autowired
	private IFlightService service;
	
	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> viewAllFlights() {
		List<Flight> flight = service.viewAllFlights();
		if(flight.isEmpty()) {
			return new ResponseEntity("Flight not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Flight>>(flight, HttpStatus.OK);
	}
	
	@GetMapping("/flights/{flightId}")
	public ResponseEntity<Flight> viewFlight(@PathVariable Long flightId) throws FlightNotFoundException {
		Flight flight = service.viewFlight(flightId);
		if(flight == null) {
			return new ResponseEntity("Flight not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}
	
	@PostMapping("/flights")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight f1) {
		Flight flight = service.addFlight(f1);
		return new ResponseEntity<Flight>(flight, HttpStatus.CREATED);
	}
	
	@PutMapping("/flights")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight f1) {
		Flight flight = service.updateFlight(f1);
		if(flight == null) {
			return new ResponseEntity("Flight not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}
	
	@DeleteMapping("/flights/{flightId}")
	public ResponseEntity<List<Flight>> removeFlight(@PathVariable Long flightId) {
		List<Flight> flight = service.removeFlight(flightId);
		if(flight.isEmpty() || flight == null) {
			return new ResponseEntity("Flight Id not available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Flight>>(flight, HttpStatus.OK);
	}
	
}
