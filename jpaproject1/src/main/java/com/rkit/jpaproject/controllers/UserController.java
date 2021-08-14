package com.rkit.jpaproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.User;
import com.rkit.jpaproject.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/welcome")
	public String welcome() {
		return service.getWelComeMessage();
		
	}
	@GetMapping("/show/{id}")
	public User showUser(@PathVariable("id")int id) {
		return service.getUserById(id);
	}
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	@GetMapping("/showall")
	public List<User> showAllUsers(){
		return service.getAllUsers();
	}
	

}
