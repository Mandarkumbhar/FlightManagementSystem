package com.training.sprint1.service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.sprint1.entities.Role;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.UserNotFoundException;
import com.training.sprint1.repository.IUserRepository;


@Service(value = "userService")
@Transactional
public class UserService implements UserDetailsService, IUserService {

	@Autowired
	IUserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = repo.findByUserName(username);
		
		
		System.out.println("user data in loadUserByUsername "+user.getUserName() +user.getPassword()+user.getRole()+"**************************");
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		Set<SimpleGrantedAuthority> auths = getAuthority(user);
		System.out.println(auths+"************************************authorities");
		return new org.springframework.security.core.userdetails.User(user.getUserName(), bcryptEncoder.encode(user.getPassword()), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		System.out.println(user.getRole()+"********************simple granted authority");
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
        authorities.add(authority);
        
		return authorities;
	}
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
	

	@Override
	public User findOne(String username) {
		return repo.findByUserName(username);
	}

	@Override
	public Role GetRole(String username) {
		User u = repo.findByUserName(username);
		return u.getRole();
	}


	
}
