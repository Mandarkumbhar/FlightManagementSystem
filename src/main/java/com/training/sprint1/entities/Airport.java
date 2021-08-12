package com.training.sprint1.entities;

public class Airport {
	
	private Long airportid;
	private String airportName;
	private String airportLocation;
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airport(String airportName, String airportLocation) {
		super();
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	public Long getAirportid() {
		return airportid;
	}
	public void setAirportid(Long airportid) {
		this.airportid = airportid;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	@Override
	public String toString() {
		return "Airport [airportid=" + airportid + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation + "]";
	}
	
	

}
