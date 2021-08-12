package com.training.sprint1.entities;

import java.math.BigInteger;

import javax.persistence.Entity;


@Entity
public class Passenger {
	
	//Data Members
private BigInteger pnrNumber;
private String passengerName;
private int age;
private BigInteger passengerUIN;
private Double luggage;

	//Constructors

	public Passenger() {
	super();
}
	
	public Passenger(BigInteger pnrNumber, String passengerName, int age, BigInteger passengerUIN, Double luggage) {
	super();
	this.pnrNumber = pnrNumber;
	this.passengerName = passengerName;
	this.age = age;
	this.passengerUIN = passengerUIN;
	this.luggage = luggage;
}
	
	
//Getters Setters
public BigInteger getPnrNumber() {
	return pnrNumber;
}
public void setPnrNumber(BigInteger pnrNumber) {
	this.pnrNumber = pnrNumber;
}
public String getPassengerName() {
	return passengerName;
}
public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public BigInteger getPassengerUIN() {
	return passengerUIN;
}
public void setPassengerUIN(BigInteger passengerUIN) {
	this.passengerUIN = passengerUIN;
}
public Double getLuggage() {
	return luggage;
}
public void setLuggage(Double luggage) {
	this.luggage = luggage;
}




}