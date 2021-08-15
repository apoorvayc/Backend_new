package com.rkit.jpaproject.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Emp_Rating;
import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.entities.User;
import com.rkit.jpaproject.service.EmpRatingService;
import com.rkit.jpaproject.service.HashtagService;

@RestController
public class EmpRatingController {
	
	@Autowired
	EmpRatingService empRatingService;
	
	@Autowired
	HashtagService service;
	
	@GetMapping("/getratingbyid/{id}")
	public Optional<Emp_Rating> showRating(@PathVariable("id")long id) {
		return empRatingService.getRatingById(id);
	}
	@PostMapping("/saverating")
	public void createRating(@RequestBody Emp_Rating empRating) {
		Timestamp instant= Timestamp.from(Instant.now()); 
		empRating.setTimestamp(instant.toString());
		String hashtagname = empRating.getDescription();
		
		System.out.println(empRating.getEmpRatingId());
		
		final Pattern TAG_PATTERN = Pattern.compile("(?:^|\\s|[\\p{Punct}&&[^/]])(#[\\p{L}0-9-_]+)");
		Matcher m = TAG_PATTERN.matcher(hashtagname);
		empRatingService.saveRating(empRating);
		while(m.find())
		{
			Hashtag h = new Hashtag();
		    String tag = m.group(1);
			h.setHashtagname(tag.substring(1));
			h.setRating(empRating.getRating()); 
			h.setEmp_rating_id(empRating.getEmpRatingId());
		    service.createHashtag(h);
		}
		
	}
	
	
	@GetMapping("/getallratings")
	public List<Emp_Rating> showAllRating(){
		return empRatingService.getAllRating();
	}

	

}
