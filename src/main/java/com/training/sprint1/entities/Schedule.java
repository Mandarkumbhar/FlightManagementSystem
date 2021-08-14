package com.training.sprint1.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
@Embeddable
public class Schedule {
	@OneToOne
   private Airport sourceAirport;
	@OneToOne
   private Airport destinationAirport;
	private LocalDate scheduleDate;
   private LocalTime arraivalTime;
   private LocalTime departureTime;
public Schedule() {
	
}

public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDate scheduleDate, LocalTime arraivalTime,
		LocalTime departureTime) {
	super();
	this.sourceAirport = sourceAirport;
	this.destinationAirport = destinationAirport;
	this.scheduleDate = scheduleDate;
	this.arraivalTime = arraivalTime;
	this.departureTime = departureTime;
}

public Airport getSourceAirport() {
	return sourceAirport;
}
public void setSourceAirport(Airport sourceAirport) {
	this.sourceAirport = sourceAirport;
}
public Airport getDestinationAirport() {
	return destinationAirport;
}
public void setDestinationAirport(Airport destinationAirport) {
	this.destinationAirport = destinationAirport;
}
public LocalTime getArraivalTime() {
	return arraivalTime;
}
public void setArraivalTime(LocalTime arraivalTime) {
	this.arraivalTime = arraivalTime;
}
public LocalTime getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(LocalTime departureTime) {
	this.departureTime = departureTime;
}

public LocalDate getDate() {
	return scheduleDate;
}

public void setDate(LocalDate scheduleDate) {
	this.scheduleDate = scheduleDate;
}

@Override
public String toString() {
	return "Schedule [sourceAirport=" + sourceAirport + ", destinationAirport=" + destinationAirport + ", date=" + scheduleDate
			+ ", arraivalTime=" + arraivalTime + ", departureTime=" + departureTime + "]";
}


   
}
