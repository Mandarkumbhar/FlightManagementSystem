package com.training.sprint1.controller;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.training.sprint1.entities.Booking;
import com.training.sprint1.exception.BookingNotFoundException;
import com.training.sprint1.service.IBookingService;





@RestController
@RequestMapping("/Booking")
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(FlightManagementSystemApplication.class);
	
	@Autowired
	IBookingService bookingService;

	
	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking b) throws BookingNotFoundException {
		Booking b1 = bookingService.addBooking(b);
		logger.info("Adding New Booking");
		return new ResponseEntity<Booking>(b1, HttpStatus.CREATED);
	}
	
	@PutMapping("/Bookings/modifyBooking")
	public ResponseEntity<Booking> modifyBooking(@RequestBody Booking b3) throws BookingNotFoundException {
		logger.info("Modifying Existing Booking");
		return new ResponseEntity<Booking>(bookingService.modifyBooking(b3), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/Bookings/{bookingId}")
	public ResponseEntity <Booking> deleteBooking(@PathVariable Long bookingId) throws BookingNotFoundException {
		logger.info("Deleting Existing Booking");
		return new ResponseEntity<Booking>(bookingService.deleteBooking(bookingId), HttpStatus.OK);
	}	
	
	
	@GetMapping("/Bookings/{Id}")
	public ResponseEntity<Booking> findBookingById(@PathVariable Long Id) throws BookingNotFoundException {
		logger.info("Finding Booking By Id");
		return new ResponseEntity<Booking>(bookingService.findBookingById(Id), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/Bookings/viewAllBookings")
	public ResponseEntity<List<Booking>> viewAllBookings() throws BookingNotFoundException {
		List<Booking> b2 = bookingService.viewAllBookings();
		logger.info("Viewing All Bookings");
		return new ResponseEntity<List<Booking>>(b2, HttpStatus.OK);
	}
	
	@GetMapping("/bookingsByDate/{bookingDate}")
	public ResponseEntity<List<Booking>> ListAllBookingsByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		logger.info("Viewing All Bookings By Booking Date");
		return new ResponseEntity<List<Booking>>(bookingService.viewAllBookingListByBookingDate(date),HttpStatus.OK);
	}


	@GetMapping("/bookingsByFlightId/{flightId}")
	public ResponseEntity<List<Booking>> ListAllBookingsByFlightId(@PathVariable Long flightId){
		logger.info("Viewing All Bookings By Flight Id");
		return new ResponseEntity<List<Booking>>(bookingService.viewAllBookingListByFlightId(flightId),HttpStatus.OK);
	}


	@GetMapping("/bookingsByUserId/{userId}")
	public ResponseEntity<List<Booking>> ListAllBookingsUserById(@PathVariable Long userId){
		logger.info("Viewing All Bookings By User Id");
		return new ResponseEntity<List<Booking>>(bookingService.viewAllBookingListByUserId(userId),HttpStatus.OK);
	}
	

}

