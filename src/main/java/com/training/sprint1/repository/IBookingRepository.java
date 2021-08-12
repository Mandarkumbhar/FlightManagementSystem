package com.training.sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sprint1.entities.*;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long>{
		
}
