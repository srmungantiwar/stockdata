package com.app.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin()
public class WelcomeResource {
	
	private final Logger logger = LoggerFactory.getLogger(WelcomeResource.class);
	
	@GetMapping(value = "/hello")
	@ApiOperation(value = "Gets all user groups",notes = "Greeting for testing", response = String.class)
	public String greeting() {
		logger.info("Welcome to Dashboard...!!!");
		return "Welcome to Dashboard...!!!";
	}
}
