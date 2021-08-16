package com.training.sprint1.entities;


import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fms_scheduledFlight")
public class ScheduledFlight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long scheduledFlightIdLong;
@ManyToOne
 private Flight flight;
 private Integer availableSeats;
 @Embedded
 private Schedule schedule;
 
public ScheduledFlight() {

}




public ScheduledFlight(Long scheduledFlightIdLong, Flight flight, Integer availableSeats, Schedule schedule) {
	super();
	this.scheduledFlightIdLong = scheduledFlightIdLong;
	this.flight = flight;
	this.availableSeats = availableSeats;
	this.schedule = schedule;
}




public ScheduledFlight(Flight flight, Integer availableSeats, Schedule schedule) {
	super();
	this.flight = flight;
	this.availableSeats = availableSeats;
	this.schedule = schedule;
}




public Long getScheduledFlightIdLong() {
	return scheduledFlightIdLong;
}

public void setScheduledFlightIdLong(Long scheduledFlightIdLong) {
	this.scheduledFlightIdLong = scheduledFlightIdLong;
}



public Flight getFlight() {
	return flight;
}




public void setFlight(Flight flight) {
	this.flight = flight;
}




public Integer getAvailableSeats() {
	return availableSeats;
}

public void setAvailableSeats(Integer availableSeats) {
	this.availableSeats = availableSeats;
}

public Schedule getSchedule() {
	return schedule;
}

public void setSchedule(Schedule schedule) {
	this.schedule = schedule;
}




@Override
public String toString() {
	return "ScheduledFlight [scheduledFlightIdLong=" + scheduledFlightIdLong + ", flight=" + flight
			+ ", availableSeats=" + availableSeats + ", schedule=" + schedule + "]";
}





 
}
