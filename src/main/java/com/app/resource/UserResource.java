package com.app.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@ApiOperation(value = "Gets all users", notes = "Fetching all users in System")
	public List<User> getAllUsers() {
		logger.debug("Fetching all users in System...!!!");
		List<User> userList = userService.getAllUsers();
		return userList;
	}

	@GetMapping(value = "/users/{token}")
	@ApiOperation(value = "Get user information by Token", notes = "Fetching user by Token from the System")
	public User getCurrentUserByToken(@PathVariable String token) {
		logger.debug("Fetching user by Id from the System...!!!");
		User user = userService.getCurrentUserByToken(token);
		return user;
	}

	@PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update user information by Id", notes = "Fetching user by Id from the System")
	public ResponseEntity<User> updateCurrentUserById(@RequestBody User user) {
		logger.debug("Updating User by Id into the System...!!!");
		return ResponseEntity.ok(userService.update(user));
	}
}
