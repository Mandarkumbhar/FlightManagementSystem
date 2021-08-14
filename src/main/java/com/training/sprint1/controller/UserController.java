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
import org.springframework.web.server.ResponseStatusException;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.exception.RecordAlreadyPresentException;
import com.training.sprint1.exception.RecordNotFoundException;
import com.training.sprint1.exception.UserNotFoundException;
import com.training.sprint1.service.IUserService;
import com.training.sprint1.service.FlightService;
import com.training.sprint1.service.IFlightService;

@RestController
@RequestMapping("/UserOperations")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired 
	private IFlightService flightService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User newUser) {
		User u1 = userService.addUser(newUser);
		return new ResponseEntity<User>(u1, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/Users/{Id}")
	public ResponseEntity<User> findUserById(@PathVariable Long Id) throws UserNotFoundException {
		try {
			return new ResponseEntity<User>(userService.findUserById(Id), HttpStatus.OK);
		} catch (UserNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this Id Not Found");
		}
	}
	
	
	@PutMapping("/Users/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User u3) {
		try {
			return new ResponseEntity<User>(userService.updateUser(u3), HttpStatus.OK);
		}catch(UserNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this Id Not Found");
		}
		
	}

	
	@DeleteMapping("/Users/{Id}")
	public ResponseEntity <User> deleteUser(@PathVariable Long Id) {
		try {
			return new ResponseEntity<User>(userService.deleteUser(Id), HttpStatus.OK);
		}catch(UserNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with this Id Not Found");
		}
		
	}
	
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<User>> viewAllUsers() throws UserNotFoundException {
		List<User> u2 = userService.viewAllUsers();
		if(u2.isEmpty()) {
			return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(u2, HttpStatus.OK);
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
