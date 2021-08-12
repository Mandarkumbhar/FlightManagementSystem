package com.training.sprint1.entities;




import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class User {
private BigInteger userId;
private String userType;
private String userName;
private String password;
private String email;
private String mobileNumber;


public User() {
	super();
}

public User(String userType, String userName, String password, String email, String mobileNumber) {
	super();
	this.userType = userType;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
}

public User(BigInteger userId, String userType, String userName, String password, String email, String mobileNumber) {
	super();
	this.userId = userId;
	this.userType = userType;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public BigInteger getUserId() {
	return userId;
}
public void setUserId(BigInteger userId) {
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

@Override
public String toString() {
	return "User [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", password=" + password
			+ ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
}


}


