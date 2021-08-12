package com.training.sprint1.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "fms_passenger")
public class Passenger {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private Long pnrNumber;
private String passengerName;
private int age;
private Long passengerUIN;
private Double luggage;

	//Constructors

	public Passenger() {
	super();
}
	
	public Passenger(Long pnrNumber, String passengerName, int age, Long passengerUIN, Double luggage) {
	super();
	this.pnrNumber = pnrNumber;
	this.passengerName = passengerName;
	this.age = age;
	this.passengerUIN = passengerUIN;
	this.luggage = luggage;
}
	
	
//Getters Setters
public Long getPnrNumber() {
	return pnrNumber;
}
public void setPnrNumber(Long pnrNumber) {
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