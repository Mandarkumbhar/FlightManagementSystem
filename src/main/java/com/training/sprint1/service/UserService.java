package com.training.sprint1.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.RecordAlreadyPresentException;
import com.training.sprint1.exception.RecordNotFoundException;
import com.training.sprint1.repository.IUserRepository;


@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository repo;
	
	@Override
	public ResponseEntity<?> addUser(User newUser) {
		// TODO Auto-generated method stub
		Optional<User> findUserById = repo.findById(newUser.getId());
		try {
			if (!findUserById.isPresent()) {
				repo.save(newUser);
				return new ResponseEntity<User>(newUser, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"User with Id: " + newUser.getId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public User updateUser(User updateUser) {
		// TODO Auto-generated method stub
		Optional<User> findUserById = repo.findById(updateUser.getId());
		if (findUserById.isPresent()) {
			repo.save(updateUser);
		} else
			throw new RecordNotFoundException(
					"User with Id: " + updateUser.getId() + " not exists!!");
		return updateUser;
	}

	@Override
	public String deleteUser(long userId) {
		// TODO Auto-generated method stub
		Optional<User> findBookingById = repo.findById(userId);
		if (findBookingById.isPresent()) {
			repo.deleteById(userId);
			return "User Deleted!!";
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	@Override
	public Iterable<User> viewUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ResponseEntity<?> findUserById(long userId) {
		// TODO Auto-generated method stub
		Optional<User> findById = repo.findById(userId);
		try {
			if (findById.isPresent()) {
				User findUser = findById.get();
				return new ResponseEntity<User>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
}
