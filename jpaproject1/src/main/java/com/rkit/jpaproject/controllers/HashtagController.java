package com.rkit.jpaproject.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Graphorpie;
import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.service.HashtagService;

@RestController
public class HashtagController {
	@Autowired
	HashtagService service;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
//	//store emp_rating_id
//	@PostMapping("/createhashtag")
//	public void createHashtag(@RequestParam("rating")Integer rating) {
//		
//		String hashtagname = "#promoted #excited"; 
//		
//		final Pattern TAG_PATTERN = Pattern.compile("(?:^|\\s|[\\p{Punct}&&[^/]])(#[\\p{L}0-9-_]+)");
//		Matcher m = TAG_PATTERN.matcher(hashtagname);
//		
//		while(m.find())
//		{
//			Hashtag h = new Hashtag();
//		    String tag = m.group(1);
//			h.setHashtagname(tag.substring(1));
//			h.setRating(rating); 
//		    service.createHashtag(h);
//		}
//
//	}
		@GetMapping("/gettophashtags")
		public List<String> gettophashtags(@RequestParam("rating")Integer Rating)
		{
			Query query = entityManager.createQuery("select hashtagname,count(hashtagname) as c from Hashtag group by hashtagname order by c desc");
		      List<Object> list = (List<Object>) query.getResultList();
		      List<String> hashtags = new ArrayList<String>();
		      for(Object h1:list) {
		    		    Object[] fields = (Object[]) h1;
		    		    String name = (String) fields[0];
		    		    Long count = (Long) fields[1];
		    		    System.out.printf("hashtagname: %s, count: %s%n", name, count);
		    		    hashtags.add(name);  
		      }
		      return hashtags; 
		}


		 
		 @GetMapping("/graphorpie")
		 public List<Graphorpie> graohorpie() {
			 Query query = entityManager.createQuery("select rating, count(empId) from Emp_Rating group by rating");
			 List<Object> list = query.getResultList();
			 List<Graphorpie> graphorpie1 = new ArrayList<Graphorpie>(); 
			 for(Object h1:list) {
				 	Graphorpie g = new Graphorpie();
	    		    Object[] fields = (Object[]) h1;
	    		    Integer rating = (Integer) fields[0];
	    		    Long noofusers = (Long) fields[1];
	    		    g.setNoofusers(noofusers);
	    		    g.setRating(rating);
	    		    System.out.printf("rating and users : %s, count: %s%n", rating, noofusers);
	    		    graphorpie1.add(g);  
	      }
			 return graphorpie1; 
		 }

}
