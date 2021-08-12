package com.training.sprint1.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "fms_airport")
public class Airport {
	@Id
	private Long id;
	private String name;
	private String location;
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airport(Long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Airport [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
	

}
