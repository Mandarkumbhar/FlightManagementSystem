package com.training.sprint1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.sprint1.entities.Flight;
import com.training.sprint1.entities.Schedule;
import com.training.sprint1.entities.ScheduledFlight;
import com.training.sprint1.exception.FlightNotFoundException;
import com.training.sprint1.repository.IScheduledFlightRepository;
import com.training.sprint1.service.ScheduledFlightService;

@SpringBootTest
class ScheduledFlightTest {
	@Mock
	IScheduledFlightRepository scheduledFlightRepository;
	
	@InjectMocks
	ScheduledFlightService scheduledFlightService;
	
	ScheduledFlight scheduledFlight1,scheduledFlight2,scheduledFlight3;
	List<ScheduledFlight> scheduledFlightslList;
	Flight flight ;
	List<Flight> flightlList;
	Schedule schedule;
	
	@SuppressWarnings("deprecation")
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@BeforeEach
	void setUp() throws Exception {
		scheduledFlightslList = new ArrayList<>();
		flightlList = new ArrayList<>();
		flight = new Flight(4554L, "Bcarrier", "Model452", 250);
		flightlList.add(flight);
		schedule = new Schedule(null, null, LocalDate.of(2021, 8, 25), null, null);
		scheduledFlight1 = new ScheduledFlight(flightlList, 50,schedule );
		scheduledFlight2 = new ScheduledFlight(flightlList, 45,schedule );
		scheduledFlight3 = new ScheduledFlight(flightlList, 72,schedule );
		scheduledFlightslList.add(scheduledFlight1);
		scheduledFlightslList.add(scheduledFlight2);
		scheduledFlightslList.add(scheduledFlight3);
		
	}
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void addScheduledFlightTest() {
		when(scheduledFlightRepository.save(scheduledFlight1)).thenReturn(scheduledFlight1);
		Assertions.assertEquals(scheduledFlight1, scheduledFlightService.addFlightSchedule(scheduledFlight1));
		
	}
	@Test
	public void removeScheduledFlightTest() throws FlightNotFoundException {
		
		when(scheduledFlightRepository.findById(scheduledFlight1.getScheduledFlightIdLong())).thenReturn(Optional.of(scheduledFlight1));
		Assertions.assertEquals(scheduledFlight1, scheduledFlightService.removeFlightSchedule(scheduledFlight1.getScheduledFlightIdLong()));
		
	}
	
	@Test
	public void updateScheduledFlightTest() throws FlightNotFoundException {
		when(scheduledFlightRepository.findById(scheduledFlight1.getScheduledFlightIdLong())).thenReturn(Optional.of(scheduledFlight1));
		when(scheduledFlightRepository.save(scheduledFlight1)).thenReturn(scheduledFlight3);
		Assertions.assertEquals(scheduledFlight3, scheduledFlightService.updateFlightSchedule(scheduledFlight1));
		
	}
	
	@Test
	public void viewAllScheduledFlightTest() {
		when(scheduledFlightRepository.findAll()).thenReturn(scheduledFlightslList);
		Assertions.assertEquals(3, scheduledFlightService.viewAllScheduledFlights().size());
		
	}
	
	/*
	 * @Test public void viewAllScheduledFlightByDateTest() {
	 * when(scheduledFlightRepository.findByScheduleDate(scheduledFlight1.
	 * getSchedule().getDate())).thenReturn(scheduledFlight1.getSchedule().getDate()
	 * ); Assertions.assertEquals(3,
	 * scheduledFlightService.viewAllScheduledFlights().size());
	 * 
	 * }
	 */
	
	
}
