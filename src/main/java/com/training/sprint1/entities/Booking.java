package com.training.sprint1.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Booking {
	
	//Data Members

private Long bookingId;
private User userId;
private LocalDate bookingDate;
private List <Passenger>passengerList;
private double ticketCost;
private Flight flight;
private int noOfPassangers;

	//Constructors

public Booking(Long bookingId, User userId, LocalDate bookingDate, List<Passenger> passengerList,
		double ticketCost, Flight flight, int noOfPassangers) {
	super();
	this.bookingId = bookingId;
	this.userId = userId;
	this.bookingDate = bookingDate;
	this.passengerList = passengerList;
	this.ticketCost = ticketCost;
	this.flight = flight;
	this.noOfPassangers = noOfPassangers;
}


	public Booking(User userId, LocalDate bookingDate, List<Passenger> passengerList, double ticketCost, Flight flight,
			int noOfPassangers) {
		super();
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flight = flight;
		this.noOfPassangers = noOfPassangers;
	}


	public Booking() {
	super();
}

	//Getters Setters
	
public Long getBookingId() {
	return bookingId;
}
public void setBookingId(Long bookingId) {
	this.bookingId = bookingId;
}
public User getUserId() {
	return userId;
}
public void setUserId(User userId) {
	this.userId = userId;
}
public LocalDate getBookingDate() {
	return bookingDate;
}
public void setBookingDate(LocalDate bookingDate) {
	this.bookingDate = bookingDate;
}
public List<Passenger> getPassengerList() {
	return passengerList;
}
public void setPassengerList(List<Passenger> passengerList) {
	this.passengerList = passengerList;
}
public double getTicketCost() {
	return ticketCost;
}
public void setTicketCost(double ticketCost) {
	this.ticketCost = ticketCost;
}
public Flight getFlight() {
	return flight;
}
public void setFlight(Flight flight) {
	this.flight = flight;
}
public int getNoOfPassangers() {
	return noOfPassangers;
}
public void setNoOfPassangers(int noOfPassangers) {
	this.noOfPassangers = noOfPassangers;
}

}

