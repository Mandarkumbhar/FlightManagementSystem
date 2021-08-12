package com.training.sprint1.entities;




import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class User {
private long userId;
private String userType;
private String userName;
private String password;
private String email;
private Long mobileNumber;


public User() {
	super();
}

public User(String userType, String userName, String password, String email, long mobileNumber) {
	super();
	this.userType = userType;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
}

public User(long userId, String userType, String userName, String password, String email, long mobileNumber) {
	super();
	this.userId = userId;
	this.userType = userType;
	this.userName = userName;
	this.password = password;
	this.email = email;
	this.mobileNumber = mobileNumber;
}
public long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
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


