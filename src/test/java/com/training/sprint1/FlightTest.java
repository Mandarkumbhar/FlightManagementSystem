package com.training.sprint1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
//import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.repository.IFlightRepository;
import com.training.sprint1.service.FlightService;


@SpringBootTest
class FlightTest {
	@Mock
	IFlightRepository repo;
	
	@InjectMocks
	FlightService service;
	Flight f1,f2,f3,f4;
	List<Flight> flights;
	
	
	@SuppressWarnings("deprecation")
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@BeforeEach
	void setUp() {
		//MockitoAnnotations.initMocks(this);
		
		 f1 = new Flight("Indigo","A320 CEO",180);
		 f2 = new Flight("Indigo","A320 NEO",180);
		 f3 = new Flight("Indigo","A321 NEO",220);
		 f4 = new Flight("Indigo","ATR600 FLEET",75);
		
		//List<Flight> flightList = Arrays.asList(f1,f2,f3,f4);
		
		flights = new ArrayList<>();
		flights.add(f1);
		flights.add(f2);
		flights.add(f3);
		flights.add(f4);
	}
	
	
	@Test
	void addFlightTest() {
		
		when(repo.save(f1)).thenReturn(f1);
		Assertions.assertEquals(f1,service.addFlight(f1));
		
	}
	
	@Test
	public void viewFlightTest() throws FlightNotFoundException {
		
		when(repo.findById(f1.getFlightId())).thenReturn(Optional.of(f1));
		Assertions.assertEquals(f1, service.viewFlight(f1.getFlightId()));
		
	}
	
	@Test
	public void viewAllFlightsTest() throws FlightNotFoundException {
		
		when(repo.findAll()).thenReturn(flights);
		Assertions.assertEquals(4, service.viewAllFlights().size());
		
	}
	
	@Test
	public void removeFlightTest() throws FlightNotFoundException {
		
		when(repo.findById(f1.getFlightId())).thenReturn(Optional.of(f1));
		Assertions.assertEquals(f1, service.removeFlight(f1.getFlightId()));
		
	}
	
	
	@Test
	public void updateFlightTest() throws FlightNotFoundException {
		when(repo.findById(f1.getFlightId())).thenReturn(Optional.of(f1));
		when(repo.save(f1)).thenReturn(f4);
		Assertions.assertEquals(f4, service.updateFlight(f1));
	}

	

}
