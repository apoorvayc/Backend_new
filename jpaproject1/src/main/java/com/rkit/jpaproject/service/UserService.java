package com.rkit.jpaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rkit.jpaproject.entities.User;
import com.rkit.jpaproject.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	@Value("${welcome.message}") String message;
	
	public String getWelComeMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public User createUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		for(User u: repository.findAll()) {
		System.out.print(u.getName());
		}
		return repository.findAll();
	}
	

}
