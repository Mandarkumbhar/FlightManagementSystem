package com.training.sprint1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.*;

@Service
public interface IBookingService {
	
	public ResponseEntity<?> addBooking(Booking newBooking);
	public Booking modifyBooking(Booking newBooking);
	public String deleteBooking(long bookingId);
	public Iterable<Booking> viewBooking();
	public ResponseEntity<?> findBookingById(long bookingId);

}
