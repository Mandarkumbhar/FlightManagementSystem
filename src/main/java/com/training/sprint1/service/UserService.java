package com.training.sprint1.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.UserNotFoundException;
import com.training.sprint1.repository.IUserRepository;


@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserRepository repo;
	
	@Override
	public User addUser(User u) {
		User addedUser = repo.save(u);
		return addedUser;
	}
	
	@Override
	public User findUserById(Long Id) throws UserNotFoundException {
		User u1 = null;
		u1 = repo.findById(Id).orElseThrow(UserNotFoundException::new);
		return u1;
	}
	
	@Override	
	public User updateUser(User u1) throws UserNotFoundException {
		User u2 = null;
		u2 = repo.findById(u1.getId()).orElseThrow(UserNotFoundException::new);
		u2.setUserName(u1.getUserName());
		u2.setPassword(u1.getPassword());
		u2.setEmail(u1.getEmail());
		u2.setMobileNumber(u1.getMobileNumber());
		
		User u3 = repo.save(u2);
		return u3;	
	}

	
	@Override	
	public User deleteUser(Long Id) throws UserNotFoundException { 
		User u2 = null;
		u2 = repo.findById(Id).orElseThrow(UserNotFoundException::new);
		repo.deleteById(Id);
		return u2;
	}


	@Override
	public List<User> viewAllUsers() {
		return repo.findAll();
	}


	
}
