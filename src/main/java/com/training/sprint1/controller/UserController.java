package com.training.sprint1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.exception.RecordAlreadyPresentException;
import com.training.sprint1.exception.RecordNotFoundException;
import com.training.sprint1.service.IUserService;
import com.training.sprint1.service.FlightService;
import com.training.sprint1.service.IFlightService;

@RestController
@RequestMapping("/UserOperations")
public class UserController {

	@Autowired
	IUserService userService;
	@Autowired private IFlightService flightService;
	@PostMapping("/addUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addUser(@RequestBody User newUser) {

		userService.addUser(newUser);
	}

	@GetMapping("/viewUsers")
	public Iterable<User> readAllUsers() {

		return userService.viewUser();
	}

	@PutMapping("/updateUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public void updateUser(@RequestBody User updateUser) {

		userService.updateUser(updateUser);
	}

	@GetMapping("/searchUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchUserByID(@PathVariable("id") long userId) {

		return userService.findUserById(userId);
	}

	@DeleteMapping("/deleteUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") long userId) {

		userService.deleteUser(userId);
	}
	
	
	
	@GetMapping("/flights/{flightId}")
	public ResponseEntity<Flight> viewFlight(@PathVariable Long flightId) throws FlightNotFoundException {
		Flight flight = flightService.viewFlight(flightId);
		if(flight == null) {
			return new ResponseEntity("Flight not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}
	@GetMapping("/flights")
	public ResponseEntity<List<Flight>> viewAllFlights() {
		List<Flight> flight = flightService.viewAllFlights();
		if(flight.isEmpty()) {
			return new ResponseEntity("Flight not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Flight>>(flight, HttpStatus.OK);
	}
	
}
