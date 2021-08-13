package com.training.sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sprint1.entities.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Long>{
	
}
