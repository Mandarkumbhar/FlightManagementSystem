package com.training.sprint1.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 private double cost;
 @Enumerated(EnumType.STRING)
 private ScheduledStatus scheduledStatus;
 
public ScheduledFlight() {

}

public ScheduledFlight(Flight flight, Integer availableSeats, Schedule schedule, double cost,
		ScheduledStatus scheduledStatus) {
	super();
	this.flight = flight;
	this.availableSeats = availableSeats;
	this.schedule = schedule;
	this.cost = cost;
	this.scheduledStatus = scheduledStatus;
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

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

public ScheduledStatus getScheduledStatus() {
	return scheduledStatus;
}

public void setScheduledStatus(ScheduledStatus scheduledStatus) {
	this.scheduledStatus = scheduledStatus;
}

@Override
public String toString() {
	return "ScheduledFlight [scheduledFlightIdLong=" + scheduledFlightIdLong + ", flight=" + flight
			+ ", availableSeats=" + availableSeats + ", schedule=" + schedule + ", cost=" + cost + ", scheduledStatus="
			+ scheduledStatus + "]";
}






 
}
