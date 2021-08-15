package com.training.sprint1.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "fms_booking")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Booking {
	
	//Data Members
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long bookingId;

@ManyToOne(cascade = CascadeType.ALL)
private User user;
private LocalDate bookingDate;
@ElementCollection
private List <Passenger>passengerList;
private double ticketCost;
@ManyToOne
private ScheduledFlight scheduledFlight;
private int noOfPassangers;

	//Constructors




	public Booking() {
	super();
}

	public Booking(User user, LocalDate bookingDate, List<Passenger> passengerList, double ticketCost,
			ScheduledFlight scheduledFlight, int noOfPassangers) {
		super();
		this.user = user;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.scheduledFlight = scheduledFlight;
		this.noOfPassangers = noOfPassangers;
	}

	//Getters Setters
	
public Long getBookingId() {
	return bookingId;
}
public void setBookingId(Long bookingId) {
	this.bookingId = bookingId;
}
public User getUser() {
	return user;
}
public void setUser(User userId) {
	this.user = userId;
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

public ScheduledFlight getScheduledFlight() {
	return scheduledFlight;
}

public void setScheduledFlight(ScheduledFlight scheduledFlight) {
	this.scheduledFlight = scheduledFlight;
}

public int getNoOfPassangers() {
	return noOfPassangers;
}
public void setNoOfPassangers(int noOfPassangers) {
	this.noOfPassangers = noOfPassangers;
}

@Override
public String toString() {
	return "Booking [bookingId=" + bookingId + ", user=" + user + ", bookingDate=" + bookingDate + ", passengerList="
			+ passengerList + ", ticketCost=" + ticketCost + ", scheduledFlight=" + scheduledFlight
			+ ", noOfPassangers=" + noOfPassangers + "]";
}


}

