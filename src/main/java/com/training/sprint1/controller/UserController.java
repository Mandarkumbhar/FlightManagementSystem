package com.training.sprint1.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.training.sprint1.entities.Role;
import com.training.sprint1.entities.ScheduledFlight;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.exception.RecordNotFoundException;
import com.training.sprint1.exception.UserNotFoundException;
import com.training.sprint1.service.IUserService;
import com.training.sprint1.service.ScheduledFlightService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,allowedHeaders={"Authorization","Access-Control-Request-Headers","Content-Type","Access-Control-Allow-Origin","Access-Control-Allow-Credentials","Access-Control-Allow-Headers"})
@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(FlightManagementSystemApplication.class);
	
	@Autowired
	IUserService userService;
	
	@Autowired
	private ScheduledFlightService scheduledFlightService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User newUser) {
		User u1 = userService.addUser(newUser);
		logger.info("Adding New User");
		return new ResponseEntity<User>(u1, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{Id}")
	public ResponseEntity<User> findUserById(@PathVariable Long Id) throws UserNotFoundException  {
		logger.info("Viewing User by Id");
		return new ResponseEntity<User>(userService.findUserById(Id), HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User u3) throws UserNotFoundException {
		logger.info("Udating Existing User");
		return new ResponseEntity<User>(userService.updateUser(u3), HttpStatus.OK);
		
		
	}

	
	@DeleteMapping("/{Id}")
	public ResponseEntity <User> deleteUser(@PathVariable Long Id) throws UserNotFoundException {
		logger.info("Deleting Existing User");
			return new ResponseEntity<User>(userService.deleteUser(Id), HttpStatus.OK);
		
		
	}
	
	@GetMapping("/id")
	public ResponseEntity <Long> GetId(@RequestParam("userName") String u5) throws RecordNotFoundException{
		return new ResponseEntity<Long>(userService.GetId(u5),HttpStatus.OK);
		}
	
	@GetMapping("/pass")
	public ResponseEntity <String> GetPassword(@RequestParam("userName") String u5) throws RecordNotFoundException{
		return new ResponseEntity<String>(userService.GetPassword(u5),HttpStatus.OK);
		}
	
	@GetMapping("/email")
	public ResponseEntity <String> GetEmail(@RequestParam("userName") String u5) throws RecordNotFoundException{
		return new ResponseEntity<String>(userService.GetEmail(u5),HttpStatus.OK);
		}
	
	@GetMapping("/mob")
	public ResponseEntity <String> GetMobileNumber(@RequestParam("userName") String u5) throws RecordNotFoundException{
		return new ResponseEntity<String>(userService.GetMobileNumber(u5),HttpStatus.OK);
		}
	
	@GetMapping("/role")
	public ResponseEntity <Role> GetRole(@RequestParam("userName") String u5) throws RecordNotFoundException{
		return new ResponseEntity<Role>(userService.GetRole(u5),HttpStatus.OK);
		}
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<User>> viewAllUsers() throws UserNotFoundException {
		List<User> u2 = userService.viewAllUsers();
		logger.info("Viewing All Users");
		return new ResponseEntity<List<User>>(u2, HttpStatus.OK);
	}
	
	
	@GetMapping("/scheduledFlightsByDate")
	public ResponseEntity<List<ScheduledFlight>> ListAllScheduledFlightsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws FlightNotFoundException{
		logger.info("Viewing All Scheduled Flights By Date");
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewAllScheduledFlightsByDate(date),HttpStatus.OK);
	}
	
	@GetMapping("/scheduledFlightsByAirportAndDate")
	public ResponseEntity<List<ScheduledFlight>> ListAllScheduledFlightsByAirportAndDate(@RequestParam("sourceAirportId") Long sourceAirportId ,@RequestParam("destinationAirportId") Long destinationAirportId ,@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws FlightNotFoundException{
		logger.info("Viewing All Scheduled Flights By Airport and Date");
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewAllScheduledFlightsByAriportAndDate(sourceAirportId, destinationAirportId, date),HttpStatus.OK);
	}
	
	@GetMapping("/scheduledFlights/{flightId}")
	public ResponseEntity<ScheduledFlight> ListAllScheduledFlightsById(@PathVariable Long flightId) throws FlightNotFoundException{
		logger.info("Viewing All Scheduled Flights By Flight Id");
		return new ResponseEntity<ScheduledFlight>(scheduledFlightService.viewFlightSchedule(flightId),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,allowedHeaders={"Authorization","Access-Control-Request-Headers","Content-Type","Access-Control-Allow-Origin","Access-Control-Allow-Credentials","Access-Control-Allow-Headers"})

	  @PostMapping("/login")
	  public ResponseEntity<User> loginCustomer(@RequestBody User c){
		   
		 System.out.println("in controller for login");
		User u =   userService.findOne(c.getUserName()) ;
		System.out.println(u + "valid user");
		return new ResponseEntity<User>(u,HttpStatus.OK);  
	  }
	
}
