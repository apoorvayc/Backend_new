package com.rkit.jpaproject.service;
import org.json.simple.JSONObject;    
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rkit.jpaproject.entities.Pair;
import com.rkit.jpaproject.entities.Quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkit.jpaproject.entities.Emp_Rating;
import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.entities.User;
import com.rkit.jpaproject.repository.EmpRatingRepository;

@Service
public class EmpRatingService {
	
	@Autowired
	EmpRatingRepository empRatingRepository;

	@Autowired
	HashtagService service;
	
	public Optional<Emp_Rating> getRatingById(long id) throws NoSuchEmployeeException {
		if (empRatingRepository.findById(id) == null){
			throw new NoSuchEmployeeException(); 
		}
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


	Quotes quotes = new Quotes();
    public JSONObject saverating(Emp_Rating empRating) {
    	Timestamp instant= Timestamp.from(Instant.now()); 
		empRating.setTimestamp(instant.toString());
		String hashtagname = empRating.getDescription();
		
		System.out.println(empRating.getEmpRatingId());
		
		final Pattern TAG_PATTERN = Pattern.compile("(?:^|\\s|[\\p{Punct}&&[^/]])(#[\\p{L}0-9-_]+)");
		Matcher m = TAG_PATTERN.matcher(hashtagname);
		saveRating(empRating);
		while(m.find())
		{
			Hashtag h = new Hashtag();
		    String tag = m.group(1);
			h.setHashtagname(tag.substring(1));
			h.setRating(empRating.getRating()); 
			h.setEmp_rating_id(empRating.getEmpRatingId());
		    service.createHashtag(h);
		}
		int rating=empRating.getRating();
		JSONObject obj=new JSONObject();    
		  obj.put("quote",quotes.getQuotes(rating-1));    

		return obj;
    }

}
