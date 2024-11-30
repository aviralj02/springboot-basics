package com.example.springboot_books.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_books.entity.User;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {
	
	// CONTROLLER FOR XML and JSON returns (USES JACKSON DATAFORMAT XML DEPENDENCY)
	// produces send in specified format
	// consumes takes in specified format (like in post, put, patch)
	
	//	In Headers:
	//		accept - application/xml or json
	//		Content-type - application/xml or json
	
	
	@GetMapping(produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
	}, 
	consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE	
	})
	public User getUsers() {
		User u = new User();
		u.setName("Aviral");
		u.setAddress("Gurgaon");
		u.setAge(20);
		
		return u;
	}
	
	@PostMapping
	public User saveUser(@RequestBody User u) {
		return u;
	}
}
