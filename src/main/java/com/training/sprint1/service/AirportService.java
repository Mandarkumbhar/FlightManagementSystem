package com.training.sprint1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Airport;
import com.training.sprint1.repository.IAirportRepository;
 
@Service
public class AirportService implements IAirportService {
    @Autowired
	private IAirportRepository repo;
	@Override
	public List<Airport> viewAirport() {
		  
		return repo.findAll();
	}

	@Override
	public Airport viewAirportById(Long id) {
		Optional<Airport> airport = repo.findById(id);
		return airport.get();
	}
	

}
