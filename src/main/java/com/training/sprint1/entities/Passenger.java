package com.training.sprint1.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;


@Embeddable
public class Passenger {
@NotEmpty(message = "Passengername must not be empty")
private String passengerName;
private int age;


private Long passengerUIN;
private Double luggage;

	//Constructors

	public Passenger() {
	super();
}
	
	

public Passenger(String passengerName, int age, Long passengerUIN, Double luggage) {
		super();
		this.passengerName = passengerName;
		this.age = age;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
	}


//Getters and Setters
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
public Long getPassengerUIN() {
	return passengerUIN;
}
public void setPassengerUIN(Long passengerUIN) {
	this.passengerUIN = passengerUIN;
}
public Double getLuggage() {
	return luggage;
}
public void setLuggage(Double luggage) {
	this.luggage = luggage;
}




}