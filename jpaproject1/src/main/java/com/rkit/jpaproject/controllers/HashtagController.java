package com.rkit.jpaproject.controllers;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Graphorpie;
import com.rkit.jpaproject.service.HashtagService;

@RestController
@CrossOrigin
public class HashtagController {
	@Autowired
	HashtagService service;
	
	@PersistenceContext
	private EntityManager entityManager;
	
		@GetMapping("/gettophashtags")
		public List<String> gettophashtags(@RequestParam("rating")Integer Rating)
		{
			return service.gettophashtags(Rating);  
		}
	 
		 @GetMapping("/graphorpie")
		 public List<Graphorpie> graohorpie() {
			 return service.graphorpie(); 
		 }

}
