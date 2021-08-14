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
import org.springframework.web.server.ResponseStatusException;
import com.training.sprint1.entities.Booking;
import com.training.sprint1.exception.BookingNotFoundException;
import com.training.sprint1.service.IBookingService;





@RestController
@RequestMapping("/Booking")
public class BookingController {

	@Autowired(required= true)
	IBookingService bookingService;

	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking b) throws BookingNotFoundException {
		Booking b1 = bookingService.addBooking(b);
		return new ResponseEntity<Booking>(b1, HttpStatus.CREATED);
	}
	
	@PutMapping("/Bookings/modifyBooking")
	public ResponseEntity<Booking> modifyBooking(@RequestBody Booking b3) {
		try {
			return new ResponseEntity<Booking>(bookingService.modifyBooking(b3), HttpStatus.OK);
		}catch(BookingNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking with this Id Not Found");
		}
		
	}
	
	
	@DeleteMapping("/Bookings/{bookingId}")
	public ResponseEntity <Booking> deleteBooking(@PathVariable Long bookingId) {
		try {
			return new ResponseEntity<Booking>(bookingService.deleteBooking(bookingId), HttpStatus.OK);
		}catch(BookingNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking with this Id Not Found");
		}
		
	}	
	
	
	@GetMapping("/Bookings/{Id}")
	public ResponseEntity<Booking> findBookingById(@PathVariable Long bookingId) throws BookingNotFoundException {
		try {
			return new ResponseEntity<Booking>(bookingService.findBookingById(bookingId), HttpStatus.OK);
		} catch (BookingNotFoundException fnfe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking with this Id Not Found");
		}
	}
	
	
	@GetMapping("/Bookings/viewAllBookings")
	public ResponseEntity<List<Booking>> viewAllBookings() throws BookingNotFoundException {
		List<Booking> b2 = bookingService.viewAllBookings();
		if(b2.isEmpty()) {
			return new ResponseEntity("Bookings not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Booking>>(b2, HttpStatus.OK);
	}
	

}

