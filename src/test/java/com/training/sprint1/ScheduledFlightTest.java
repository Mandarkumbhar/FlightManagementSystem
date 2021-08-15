package com.training.sprint1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
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

import com.training.sprint1.entities.Airport;
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
	List<ScheduledFlight> scheduledFlightslListByDate;
	List<ScheduledFlight> scheduledFlightslListByAirportAndDate;
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
		scheduledFlightslListByDate = new ArrayList<>();
		scheduledFlightslListByAirportAndDate = new ArrayList<>();
		flightlList = new ArrayList<>();
		flight = new Flight(4554L, "Bcarrier", "Model452", 250);
		flightlList.add(flight);
		Airport a1 = new Airport(11l, "Bombay Airlines", "Mumbai");
		Airport a2 = new Airport(12l, "Pune Airlines", "Pune");
		Airport a3 = new Airport(13l, "Thane Airlines", "Thane");
		Airport a4 = new Airport(14l, "Jaipur Airlines", "Jaipur");
		Airport a5 = new Airport(15l, "Raipur Airlines", "Raipur");
		Airport a6 = new Airport(16l, "Bangalore Airlines", "Bangalore");
		Schedule s1 =  new Schedule(a1, a2,LocalDate.of(2021, 8, 23) ,LocalTime.of(6, 30), LocalTime.of(7, 30));
		Schedule s2 =  new Schedule(a3, a4, LocalDate.of(2021, 8, 23) ,LocalTime.of(8, 30), LocalTime.of(9, 00));
		Schedule s3 =  new Schedule(a5, a6,LocalDate.of(2021, 8, 25) , LocalTime.of(4, 30), LocalTime.of(6, 00));
		scheduledFlight1 = new ScheduledFlight(flightlList, 50,s1 );
		scheduledFlight2 = new ScheduledFlight(flightlList, 45,s2 );
		scheduledFlight3 = new ScheduledFlight(flightlList, 72,s3);
		scheduledFlightslList.add(scheduledFlight1);
		scheduledFlightslList.add(scheduledFlight2);
		scheduledFlightslList.add(scheduledFlight3);
		scheduledFlightslListByDate.add(scheduledFlight1);
		scheduledFlightslListByDate.add(scheduledFlight2);
		scheduledFlightslListByAirportAndDate.add(scheduledFlight1);
		
		
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
	
	
	  @Test 
	  public void viewAllScheduledFlightByDateTest() {
	  when(scheduledFlightRepository.findByScheduleScheduleDate(scheduledFlight1.getSchedule().getScheduleDate())).thenReturn(scheduledFlightslListByDate); 
	  Assertions.assertEquals(2,scheduledFlightService.viewAllScheduledFlightsByDate(scheduledFlight1.getSchedule().getScheduleDate()).size());
	  
	  }
	 
	  @Test 
	  public void viewAllScheduledFlightByAirportAndDateTest() {
	  when(scheduledFlightRepository.findByScheduleSourceAirportIdAndDestinationAirportIdAndScheduleDate(scheduledFlight1.getSchedule().getSourceAirport().getId(),scheduledFlight1.getSchedule().getDestinationAirport().getId(),scheduledFlight1.getSchedule().getScheduleDate())).thenReturn(scheduledFlightslListByAirportAndDate); 
	  Assertions.assertEquals(1,scheduledFlightService.viewAllScheduledFlightsByAriportAndDate(scheduledFlight1.getSchedule().getSourceAirport().getId(),scheduledFlight1.getSchedule().getDestinationAirport().getId(),scheduledFlight1.getSchedule().getScheduleDate()).size());
	  
	  }
	
	
}
