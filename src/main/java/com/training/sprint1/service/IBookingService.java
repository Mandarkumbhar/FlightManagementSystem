package com.training.sprint1.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.*;
import com.training.sprint1.exception.BookingNotFoundException;

@Service
public interface IBookingService {
	
	public Booking addBooking(Booking newBooking); 
	public Booking modifyBooking(Booking newBooking) throws BookingNotFoundException; 
	public Booking deleteBooking(Long bookingId) throws BookingNotFoundException;
	public List<Booking> viewAllBookings();
	public Booking findBookingById(Long bookingId) throws BookingNotFoundException;

}
