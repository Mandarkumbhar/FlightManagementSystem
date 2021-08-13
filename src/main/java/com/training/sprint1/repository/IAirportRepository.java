package com.training.sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.sprint1.entities.Airport;

public interface IAirportRepository extends JpaRepository<Airport, Long>{

}
