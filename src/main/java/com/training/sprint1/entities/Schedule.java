package com.training.sprint1.entities;

import java.time.LocalTime;

public class Schedule {
   private Airport sourceAirport;
   private Airport destinationAirport;
   private LocalTime arraivalTime;
   private LocalTime departureTime;
public Schedule() {
	
}
public Schedule(Airport sourceAirport, Airport destinationAirport, LocalTime arraivalTime, LocalTime departureTime) {
	this.sourceAirport = sourceAirport;
	this.destinationAirport = destinationAirport;
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

   
}