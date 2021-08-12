package com.training.sprint1.entities;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
private Long userId;
private String userType;
private String userName;
private String password;
private String email;
private Long mobileNumber;

@OneToMany(mappedBy = "user")
private List<Booking> bookings;


public User() {
	super();
}


public User(Long userId, String userType, String userName, String password, String email, Long mobileNumber,
		List<Booking> bookings) {
	super();
	this.userId = userId;
	this.userType = userType;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.bookings = bookings;
}


public User(String userType, String userName, String password, String email, Long mobileNumber,
		List<Booking> bookings) {
	super();
	this.userType = userType;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.bookings = bookings;
}


public Long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(Long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
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

public List<Booking> getBookings() {
	return bookings;
}


public void setBookings(List<Booking> bookings) {
	this.bookings = bookings;
}


@Override
public String toString() {
	return "User [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", password=" + password
			+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", bookings=" + bookings + "]";
}





}


