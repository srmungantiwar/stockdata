package com.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	
	@GetMapping(value = "/hello")
	public String greeting() {
		return "Hello";
	}
}
