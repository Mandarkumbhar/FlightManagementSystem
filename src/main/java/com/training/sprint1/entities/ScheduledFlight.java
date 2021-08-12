package com.training.sprint1.entities;

public class ScheduledFlight {
 private Flight flight;
 private Integer availableSeats;
 private Schedule schedule;
 
public ScheduledFlight() {

}
public ScheduledFlight(Flight flight, Integer availableSeats, Schedule schedule) {
	this.flight = flight;
	this.availableSeats = availableSeats;
	this.schedule = schedule;
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


 
}
