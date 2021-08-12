package com.training.sprint1.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fms_flight")
public class Flight {
	
	//Data Members
@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private Long flightId;
private String carrierName;
private String flightModel;
private int seatCapacity;

	//Constructors

	public Flight() {
	super();
}
	
	public Flight(Long flightId, String carrierName, String flightModel, int seatCapacity) {
	super();
	this.flightId = flightId;
	this.carrierName = carrierName;
	this.flightModel = flightModel;
	this.seatCapacity = seatCapacity;
}
	
	//Getters Setters
	
public Long getFlightId() {
	return flightId;
}
public void setFlightId(Long flightId) {
	this.flightId = flightId;
}
public String getCarrierName() {
	return carrierName;
}
public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
}
public String getFlightModel() {
	return flightModel;
}
public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
}
public int getSeatCapacity() {
	return seatCapacity;
}
public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
}



}