package com.app.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserResource {
	
	
private final Logger logger = LoggerFactory.getLogger(WelcomeResource.class);

@Autowired
private UserService userService;

	@GetMapping(value = "/users")
	@ApiOperation(value = "Gets all users",notes = "Fetching all users in System")
	public List<User> getAllUsers() {
		logger.debug("Fetching all users in System...!!!");
		List<User> userList = userService.getAllUsers();
		return userList;
	}
	
	@GetMapping(value = "/users/{token}")
	@ApiOperation(value = "Get user information by Id",notes = "Fetching user by Id from the System")
	public User getCurrentUserByToken(@PathVariable String token) {
		logger.debug("Fetching user by Id from the System...!!!");
		User user = userService.getCurrentUserByToken(token);
		return user;
	}
}
