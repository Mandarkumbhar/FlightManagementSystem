package com.training.sprint1.service;

import java.util.List; 

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Role;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.UserNotFoundException;


@Service
public interface IUserService {

	public User addUser(User user);
	public User findUserById(Long Id) throws UserNotFoundException;
	public User updateUser(User user) throws UserNotFoundException;
	public User deleteUser(Long Id) throws UserNotFoundException;
	public List<User> viewAllUsers();
	public UserDetails loadUserByUsername(String username) throws UserNotFoundException;
	public User findOne(String username);
	public Role GetRole(String username);
	public Long GetId(String username);
	public String GetPassword(String username);
	public String GetEmail(String username);
	public String GetMobileNumber(String username);
}
