package com.rkit.jpaproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkit.jpaproject.entities.Graphorpie;
import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.repository.HashtagRepository;

@Service
public class HashtagService {
	@Autowired
	HashtagRepository repository;

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Hashtag createHashtag(Hashtag hashtag) {
		// TODO Auto-generated method stub
		return repository.save(hashtag);
	}
	public List<String> gettophashtags(Integer Rating) {
		Query query = entityManager.createQuery("select hashtagname,count(hashtagname),rating as c from Hashtag where rating="+Rating+" group by hashtagname order by c desc");
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
	
	public List<Graphorpie> graphorpie() {
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
