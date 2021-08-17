package com.rkit.jpaproject.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Emp_Rating;
import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.entities.Quotes;
import com.rkit.jpaproject.entities.User;
import com.rkit.jpaproject.service.EmpRatingService;
import com.rkit.jpaproject.service.HashtagService;

@RestController
@CrossOrigin

public class EmpRatingController {
	
	@Autowired
	EmpRatingService empRatingService;
	

	
	Quotes quotes = new Quotes();
	
	@GetMapping("/getratingbyid/{id}")
	public Optional<Emp_Rating> showRating(@PathVariable("id")long id) {
		return empRatingService.getRatingById(id);
	}
	@PostMapping("/saverating")
	public JSONObject createRating(@RequestBody Emp_Rating empRating) {
		return empRatingService.saverating(empRating);
	}
	
	@GetMapping("/getallratings")
	public List<Emp_Rating> showAllRating(){
		return empRatingService.getAllRating();
	}

	

}
