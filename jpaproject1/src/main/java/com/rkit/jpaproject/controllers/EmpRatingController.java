package com.rkit.jpaproject.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Query;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Emp_Rating;
import com.rkit.jpaproject.entities.Graphorpie;
import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.entities.Quotes;
import com.rkit.jpaproject.entities.User;
import com.rkit.jpaproject.service.EmpRatingService;
import com.rkit.jpaproject.service.HashtagService;
import com.rkit.jpaproject.service.NoSuchEmployeeException;

@RestController
public class EmpRatingController {
	
	@Autowired
	EmpRatingService empRatingService;
	

	
	Quotes quotes = new Quotes();
	
	@GetMapping("/getratingbyid/{id}")
	public Optional<Emp_Rating> showRating(@PathVariable("id")long id) throws NoSuchEmployeeException {
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

    @GetMapping("getEmployeeRatings/{id}")
    public List<JSONObject> getemployeeratings(@PathVariable("id")int id) {
    	return empRatingService.getemployeeratings(id); 
    }


}
