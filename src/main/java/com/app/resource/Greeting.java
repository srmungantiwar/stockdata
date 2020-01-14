package com.app.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class Greeting {
	private final Logger logger = LoggerFactory.getLogger(Greeting.class);
	
	@GetMapping(value = "/hello")
	@ApiOperation(value = "Gets all user groups",notes = "Greeting for testing", response = String.class)
	public String greeting() {
		logger.info("Hello:::::::::::::::::::::");
		return "Hello";
	}
}
