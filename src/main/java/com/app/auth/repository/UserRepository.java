package com.app.auth.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.auth.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
