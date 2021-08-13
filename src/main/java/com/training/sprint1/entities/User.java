package com.training.sprint1.entities;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "fms_users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Enumerated(EnumType.STRING)
private Role role;
private String userName;
private String password;
private String email;
private Long mobileNumber;

@OneToMany(mappedBy = "user")
private List<Booking> bookings;


public User() {
	super();
}


public User(Role role, String userName, String password, String email, Long mobileNumber, List<Booking> bookings) {
	super();
	this.role = role;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.bookings = bookings;
}




public User(Long id, Role role, String userName, String password, String email, Long mobileNumber,
		List<Booking> bookings) {
	super();
	this.id = id;
	this.role = role;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.bookings = bookings;
}



public User(Role role, String userName, String password, String email, Long mobileNumber) {
	super();
	this.role = role;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public Role getRole() {
	return role;
}


public void setRole(Role role) {
	this.role = role;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public Long getMobileNumber() {
	return mobileNumber;
}


public void setMobileNumber(Long mobileNumber) {
	this.mobileNumber = mobileNumber;
}


public List<Booking> getBookings() {
	return bookings;
}


public void setBookings(List<Booking> bookings) {
	this.bookings = bookings;
}


@Override
public String toString() {
	return "User [id=" + id + ", role=" + role + ", userName=" + userName + ", password=" + password + ", email="
			+ email + ", mobileNumber=" + mobileNumber + ", bookings=" + bookings + "]";
}







}


