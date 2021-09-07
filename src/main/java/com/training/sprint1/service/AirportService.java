package com.training.sprint1.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.sprint1.entities.Airport;
import com.training.sprint1.exception.AirportNotFoundException;
import com.training.sprint1.repository.IAirportRepository;
 
@Service
@Transactional
public class AirportService implements IAirportService {
	
    @Autowired
	private IAirportRepository repo;
    
    
    
	@Override
	public List<Airport> viewAirport() {
		
		
		List<Airport> airports = repo.findAll();
		return airports;
	}

	@Override
	public Airport viewAirportById(Long id) throws AirportNotFoundException{
		Airport airport = repo.findById(id).orElseThrow(AirportNotFoundException::new);
		return airport;
	}
	

}
