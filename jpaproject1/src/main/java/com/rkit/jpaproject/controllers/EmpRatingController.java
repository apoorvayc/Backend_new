package com.rkit.jpaproject.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Emp_Rating;
import com.rkit.jpaproject.entities.User;
import com.rkit.jpaproject.service.EmpRatingService;

@RestController
@RequestMapping("/ratings")
public class EmpRatingController {
	
	@Autowired
	EmpRatingService empRatingService;
	
	@GetMapping("/rating/{id}")
	public Optional<Emp_Rating> showRating(@PathVariable("id")long id) {
		return empRatingService.getRatingById(id);
	}
	@PostMapping("/save")
	public Emp_Rating createRating(@RequestBody Emp_Rating empRating) {
		Timestamp instant= Timestamp.from(Instant.now()); 
		empRating.setTimestamp(instant.toString());
		
		return empRatingService.saveRating(empRating);
	}
	@GetMapping("/showall")
	public List<Emp_Rating> showAllRating(){
		return empRatingService.getAllRating();
	}
	
	
	

}
