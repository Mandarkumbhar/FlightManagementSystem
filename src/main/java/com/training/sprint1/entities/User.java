package com.training.sprint1.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "fms_users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Enumerated(EnumType.STRING)
private Role role;

@NotEmpty(message = "Username must not be empty")
private String userName;

@NotEmpty(message = "Password must not be empty")
@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Password should  contains at least 8 characters and at most 20 characters, at least one digit, at least one upper case alphabet, at least one lower case alphabet and at least one special character ")
private String password;

@Email(message = "Email should be valid")
private String email;

@Pattern(regexp="(^$|[0-9]{10})", message =  "Mobile Number should be valid")
private String mobileNumber;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
@JsonIgnore
private List<Booking> bookings;


public User() {
	super();
}


public User(Role role, String userName, String password, String email, String mobileNumber, List<Booking> bookings) {
	super();
	this.role = role;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.bookings = bookings;
}




public User(Long id, Role role, String userName, String password, String email, String mobileNumber,
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



public User(Role role, String userName, String password, String email, String mobileNumber) {
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





public String getMobileNumber() {
	return mobileNumber;
}


public void setMobileNumber(String mobileNumber) {
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


