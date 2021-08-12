package com.training.sprint1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.User;


@Service
public interface IUserService {

	public ResponseEntity addUser(User newUser);
	public User updateUser(User newUser);
	public String deleteUser(long userId);
	public Iterable<User> viewUser();
	public ResponseEntity findUserById(long userId);
}
