package com.rkit.jpaproject.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkit.jpaproject.entities.Emp_Rating;
import com.rkit.jpaproject.entities.User;
import com.rkit.jpaproject.repository.EmpRatingRepository;

@Service
public class EmpRatingService {
	
	@Autowired
	EmpRatingRepository empRatingRepository;

	public Optional<Emp_Rating> getRatingById(long id) {
		return empRatingRepository.findById(id);
		
	}
	public List<Emp_Rating> getAllRating() {
		return empRatingRepository.findAll();
	}


	public Emp_Rating saveRating(Emp_Rating empRating) {
		Timestamp instant= Timestamp.from(Instant.now()); 
		empRating.setTimestamp(instant.toString());
		
		return empRatingRepository.save(empRating);
	}
	

}
