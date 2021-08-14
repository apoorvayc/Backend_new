package com.rkit.jpaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.repository.HashtagRepository;

@Service
public class HashtagService {
	@Autowired
	HashtagRepository repository;

	public Hashtag createHashtag(Hashtag hashtag) {
		// TODO Auto-generated method stub
		return repository.save(hashtag);
	}
	

}
