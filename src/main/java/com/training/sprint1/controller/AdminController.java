package com.training.sprint1.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.training.sprint1.FlightManagementSystemApplication;
import com.training.sprint1.entities.Airport;
import com.training.sprint1.entities.Flight;
import com.training.sprint1.entities.ScheduledFlight;
import com.training.sprint1.exception.AirportNotFoundException;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.service.IAirportService;
import com.training.sprint1.service.IFlightService;
import com.training.sprint1.service.ScheduledFlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(FlightManagementSystemApplication.class);
	@Autowired
	private IFlightService flightService;
	@Autowired
	private IAirportService airportService;
	@Autowired
	private ScheduledFlightService scheduledFlightService;
	
	
	@GetMapping("/airports")
	public ResponseEntity<List<Airport>> viewAirport() {
		List<Airport> airport = airportService.viewAirport();
		logger.info("Viewing all Airports");
		return new ResponseEntity<List<Airport>>(airport, HttpStatus.OK);
	}
	
	
	@GetMapping("/airports/{airportId}")
	public ResponseEntity<Airport> viewAirportById(@PathVariable Long airportId) throws AirportNotFoundException{
		Airport airport = airportService.viewAirportById(airportId);
		logger.info("Viewing Airport By Id");
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
	}
	
	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> viewAllFlights() throws FlightNotFoundException {
		logger.info("Viewing all Flights");
		return new ResponseEntity<List<Flight>>(flightService.viewAllFlights(), HttpStatus.OK);
		
	}
	
	@GetMapping("/flights/{flightId}")
	public ResponseEntity<Flight> viewFlight(@PathVariable Long flightId) throws FlightNotFoundException {
		logger.info("Viewing Flight By Id");
		return new ResponseEntity<Flight>(flightService.viewFlight(flightId), HttpStatus.OK);
		
	}
	
	@PostMapping("/flights")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight f1) {
		Flight flight = flightService.addFlight(f1);
		logger.info("Adding New Flight");
		return new ResponseEntity<Flight>(flight, HttpStatus.CREATED);
	}
	
	@PutMapping("/flights")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight f1) throws FlightNotFoundException {
		logger.info("Updating Existing Flight");
		return new ResponseEntity<Flight>(flightService.updateFlight(f1), HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/flights/{flightId}")
	public ResponseEntity <Flight> removeFlight(@PathVariable Long flightId) throws FlightNotFoundException {
		logger.info("Deleting Existing Flight");
		return new ResponseEntity<Flight>(flightService.removeFlight(flightId), HttpStatus.OK);
		
		
	}
	
	@GetMapping("/scheduledFlights")
	public ResponseEntity<List<ScheduledFlight>> ListAllScheduledFlights(){
		logger.info("Viewing All Scheduled Flights");
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewAllScheduledFlights(),HttpStatus.OK);
	}
	
	@PostMapping("/scheduledFlights")
	public ResponseEntity<ScheduledFlight> addScheduledFlight(@RequestBody ScheduledFlight f1) {
		ScheduledFlight scheduledFlight = scheduledFlightService.addFlightSchedule(f1);
		logger.info("Adding New Scheduled Flights");
		return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.CREATED);
	}
	
	@PutMapping("/scheduledFlights")
	public ResponseEntity<ScheduledFlight> updateScheduledFlight(@RequestBody ScheduledFlight f1) throws FlightNotFoundException {
		ScheduledFlight scheduledFlight;
		logger.info("Updating Scheduled Flights");
			scheduledFlight = scheduledFlightService.updateFlightSchedule(f1);
			return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/scheduledFlights/{Id}")
	public ResponseEntity<ScheduledFlight> deleteScheduledFlight(@PathVariable Long Id) throws FlightNotFoundException {
		ScheduledFlight scheduledFlight;
		logger.info("Deleted Scheduled Flights By ID");
			scheduledFlight = scheduledFlightService.removeFlightSchedule(Id);
			return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/scheduledFlightsByDate")
	public ResponseEntity<List<ScheduledFlight>> ListAllScheduledFlightsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		logger.info("Viewing All Scheduled Flights By Date");
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewAllScheduledFlightsByDate(date),HttpStatus.OK);
	}
	
	@GetMapping("/scheduledFlightsByAirportAndDate")
	public ResponseEntity<List<ScheduledFlight>> ListAllScheduledFlightsByAirportAndDate(@RequestParam("sourceAirportId") Long sourceAirportId ,@RequestParam("destinationAirportId") Long destinationAirportId ,@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		logger.info("Viewing All Scheduled Flights By Airport and Date");
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewAllScheduledFlightsByAriportAndDate(sourceAirportId, destinationAirportId, date),HttpStatus.OK);
	}
	
	@GetMapping("/scheduledFlights/{flightId}")
	public ResponseEntity<List<ScheduledFlight>> ListAllScheduledFlightsById(@PathVariable Long flightId){
		logger.info("Viewing All Scheduled Flights By Flight Id");
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewFlightSchedule(flightId),HttpStatus.OK);
	}
}
