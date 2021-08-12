package com.training.sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.sprint1.entities.Flight;

public interface IFlightRepository extends JpaRepository<Flight, Long>{
	
}
