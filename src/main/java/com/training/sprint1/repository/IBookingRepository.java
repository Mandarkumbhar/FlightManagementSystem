package com.training.sprint1.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.sprint1.entities.*;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long>{
	
	List<Booking> findByBookingDate(LocalDate date);
	
	@Query("SELECT bf FROM Booking bf  WHERE bf.scheduledFlight.flight.flightId=:fi")	
	List<Booking> viewAllBookingListByFlightId(@Param("fi") Long flightId);
	
	@Query("SELECT bf FROM Booking bf  WHERE bf.user.id=:ud")
	List<Booking> viewAllBookingListByUserId(@Param("ud") Long userId);
		
}
