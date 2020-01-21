package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	User findByUsername(String username);
}
