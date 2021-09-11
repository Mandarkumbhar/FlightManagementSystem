package com.training.sprint1.entities;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

@ManyToOne(fetch = FetchType.LAZY)
private User user;
private LocalDate bookingDate;

@ElementCollection(fetch = FetchType.EAGER)
private List <Passenger>passengerList;

@Enumerated(EnumType.STRING)
private BookingStatus bookingStatus;

@ManyToOne
private ScheduledFlight scheduledFlight;
private int noOfPassangers;

	//Constructors




	public Booking() {
	super();
}

	public Booking(User user, LocalDate bookingDate, List<Passenger> passengerList, BookingStatus bookingStatus,
			ScheduledFlight scheduledFlight, int noOfPassangers) {
		super();
		this.user = user;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.bookingStatus = bookingStatus;
		this.scheduledFlight = scheduledFlight;
		this.noOfPassangers = noOfPassangers;
	}
	
	

	public Booking(User user, LocalDate bookingDate, List<Passenger> passengerList, ScheduledFlight scheduledFlight,
			int noOfPassangers) {
		super();
		this.user = user;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.scheduledFlight = scheduledFlight;
		this.noOfPassangers = noOfPassangers;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
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
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", bookingDate=" + bookingDate
				+ ", passengerList=" + passengerList + ", bookingStatus=" + bookingStatus + ", scheduledFlight="
				+ scheduledFlight + ", noOfPassangers=" + noOfPassangers + "]";
	}

	
	


}

