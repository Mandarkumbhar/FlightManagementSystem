package com.training.sprint1.entities;

import java.math.BigInteger;

import javax.persistence.Entity;

@Entity
public class Flight {
	
	//Data Members
	
private BigInteger flightId;
private String carrierName;
private String flightModel;
private int seatCapacity;

	//Constructors

	public Flight() {
	super();
}
	
	public Flight(BigInteger flightId, String carrierName, String flightModel, int seatCapacity) {
	super();
	this.flightId = flightId;
	this.carrierName = carrierName;
	this.flightModel = flightModel;
	this.seatCapacity = seatCapacity;
}
	
	//Getters Setters
	
public BigInteger getFlightId() {
	return flightId;
}
public void setFlightId(BigInteger flightId) {
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