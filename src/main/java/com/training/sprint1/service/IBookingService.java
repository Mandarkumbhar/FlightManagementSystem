package com.training.sprint1.service;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.training.sprint1.entities.*;
import com.training.sprint1.exception.BookingNotFoundException;

@Service
@Transactional
public interface IBookingService {
	
	public Booking addBooking(Booking newBooking); 
	public Booking modifyBooking(Booking newBooking) throws BookingNotFoundException; 
	public Booking deleteBooking(Long bookingId) throws BookingNotFoundException;
	public List<Booking> viewAllBookings();
	public Booking findBookingById(Long bookingId) throws BookingNotFoundException;
	public List<Booking> viewAllBookingListByBookingDate(LocalDate date);
	public List<Booking> viewAllBookingListByFlightId(Long flightId);
	public List<Booking> viewAllBookingListByUserId(Long userId);

}
