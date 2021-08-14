package com.training.sprint1.service;
import com.training.sprint1.exception.BookingNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Booking;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.RecordAlreadyPresentException;
import com.training.sprint1.exception.RecordNotFoundException;
import com.training.sprint1.exception.UserNotFoundException;
import com.training.sprint1.repository.IBookingRepository;




@Service
public class BookingService implements IBookingService {


	@Autowired
	IBookingRepository brepo;

	@Override	
	public Booking addBooking(Booking b) {
		Booking addedBooking = brepo.save(b);
		return addedBooking;
	}
	

	@Override
	public Booking modifyBooking(Booking b1) throws BookingNotFoundException {
		Booking b2 = null;
		b2 = brepo.findById(b1.getBookingId()).orElseThrow(BookingNotFoundException::new);
		b2.setBookingDate(b1.getBookingDate());
		
		Booking b3 = brepo.save(b2);
		return b3;	
	}

		
	
	@Override	
	public Booking deleteBooking(Long bookingId) throws BookingNotFoundException { 
		Booking b2 = null;
		b2 = brepo.findById(bookingId).orElseThrow(BookingNotFoundException::new);
		brepo.deleteById(bookingId);
		return b2;
	}


	@Override
	public List<Booking> viewAllBookings() {

		return brepo.findAll();
	}

	
	public Booking findBookingById(Long bookingId) throws BookingNotFoundException {
		Booking b4 = null;
		b4 = brepo.findById(bookingId).orElseThrow(BookingNotFoundException::new);
		return b4;
	}
	

}
