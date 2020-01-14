package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	private final Logger logger = LoggerFactory.getLogger(Greeting.class);
	
	@GetMapping(value = "/hello")
	public String greeting() {
		logger.info("Hello:::::::::::::::::::::");
		return "Hello";
	}
}
