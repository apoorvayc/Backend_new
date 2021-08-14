package com.rkit.jpaproject.controllers;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.service.HashtagService;

@RestController
public class HashtagController {
	@Autowired
	HashtagService service;
	
	@PersistenceContext
	private EntityManager entityManager;
		
	@PostMapping("/createhashtag")
	public void createHashtag(@RequestParam("rating")Integer rating) {
		
		String hashtagname = "Very happy #veryhappy #promotion #happy"; 
		
		final Pattern TAG_PATTERN = Pattern.compile("(?:^|\\s|[\\p{Punct}&&[^/]])(#[\\p{L}0-9-_]+)");
		Matcher m = TAG_PATTERN.matcher(hashtagname);
		
		while(m.find())
		{
			Hashtag h = new Hashtag();
		    String tag = m.group(1);
			h.setHashtagname(tag);
			h.setRating(rating); 
			UUID uid = UUID.randomUUID();
			h.setId(uid);
		    service.createHashtag(h);
		}

		

	      //Scalar function
	      Query query = entityManager.createQuery("select hashtagname,count(hashtagname) from Hashtag group by hashtagname");
	      List<Object> list = (List<Object>) query.getResultList();

	      for(Object h1:list) {
	    		    Object[] fields = (Object[]) h1;
	    		    String id = (String) fields[0];
	    		    Long name = (Long) fields[1];
	    		    System.out.printf("hashtagname: %s, count: %s%n", id, name);
	      }
	      
	      

//		return service.createHashtag(h);
	}

}
