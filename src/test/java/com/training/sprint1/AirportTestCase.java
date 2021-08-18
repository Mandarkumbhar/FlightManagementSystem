package com.training.sprint1;


import static org.mockito.Mockito.when;
import java.util.*;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.training.sprint1.entities.Airport;
import com.training.sprint1.exception.AirportNotFoundException;
import com.training.sprint1.repository.IAirportRepository;
import com.training.sprint1.service.AirportService;

@SpringBootTest
class AirportTestCase {
	@Mock
	IAirportRepository repo;
	@InjectMocks
	AirportService service;
	Airport A1,A2,A3,A4,A5;
	List<Airport> airports;
	@SuppressWarnings("deprecation")
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@BeforeEach
	void setUp() {
		A1 = new Airport((long)11001,"ABC","MUMBAI");
		A2 = new Airport((long)11002,"EFG","HYD");
		A3 = new Airport((long)11003,"HIJ", "CHENNAI");
		A4 = new Airport((long)11004,"PQRS", "DELHI");
		A5 = new Airport((long)11001, "XYZ", "MUMBAI");
		
		airports = new ArrayList<Airport>();
		airports.add(A1);
		airports.add(A2);
		airports.add(A3);
		airports.add(A4);
		airports.add(A5);
	}
	
	@Test
	public void viewAirport(){
		when(repo.findAll()).thenReturn(airports);
		Assertions.assertEquals(5, service.viewAirport().size());
	}
	@Test
	public void viewAirportById() throws AirportNotFoundException{
		when(repo.findById(A1.getId())).thenReturn(Optional.of(A1));
		Assertions.assertEquals(A1, service.viewAirportById(A1.getId()));	
	}

}

