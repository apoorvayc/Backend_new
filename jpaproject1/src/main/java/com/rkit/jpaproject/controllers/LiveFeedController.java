package com.rkit.jpaproject.controllers;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.entities.Record;
import com.rkit.jpaproject.service.DashboardService;
import com.rkit.jpaproject.service.EmpRatingService;

@RestController
public class LiveFeedController {
	@Autowired
	DashboardService service;

	@PersistenceContext
	private EntityManager entityManager;

	//sort by timestamp and add timestamp  
	@GetMapping("/livefeed")
	public List<Record> getallRecord() {
		return service.livefeed(); 
	}
	
	
	@GetMapping("/searchHashtag/{hashtag}")
	public List<Record> searchRatingwise(@PathVariable("hashtag")String hashtag) {
		return service.searchinratingtable(hashtag);
	}

}
