package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	User findByUsername(String username);
	Optional<List<User>> findByUsernameOrEmail(String username, String username2);
}
