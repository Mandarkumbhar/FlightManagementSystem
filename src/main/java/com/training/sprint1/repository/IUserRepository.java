package com.training.sprint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.sprint1.entities.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}