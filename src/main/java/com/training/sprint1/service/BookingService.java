package com.training.sprint1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Booking;
import com.training.sprint1.exception.RecordAlreadyPresentException;
import com.training.sprint1.exception.RecordNotFoundException;
import com.training.sprint1.repository.IBookingRepository;




@Service
public class BookingService implements IBookingService {


	@Autowired
	IBookingRepository brepo;

	@Override
	public ResponseEntity<Booking> addBooking(Booking newBooking) {

		Optional<Booking> findBookingById = brepo.findById(newBooking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				brepo.save(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public Booking modifyBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = brepo.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			brepo.save(changedBooking);
		} else
			throw new RecordNotFoundException(
					"Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		return changedBooking;
	}



	@Override
	public String deleteBooking(long bookingId) {

		Optional<Booking> findBookingById = brepo.findById(bookingId);
		if (findBookingById.isPresent()) {
			brepo.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingID");
	}


	@Override
	public Iterable<Booking> viewBooking() {

		return brepo.findAll();
	}


	@Override
	public ResponseEntity<?> findBookingById(long bookingId) {
		Optional<Booking> findById = brepo.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + bookingId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


}
