package com.rkit.jpaproject.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.entities.Record;
import com.rkit.jpaproject.service.EmpRatingService;

@RestController
public class LiveFeedController {
	@Autowired
	EmpRatingService service;

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/livefeed")
	public List<Record> getallRecord() {

		Query query = entityManager.createQuery(
				"select e.name,r.rating,r.description from Emp_Rating r  join Employee e on r.empId = e.id");
		List<Object> list = (List<Object>) query.getResultList();
		List<Record> records = new ArrayList<Record>();
		for (Object h1 : list) {
			Object[] fields = (Object[]) h1;

			String name = (String) fields[0];
			int rating = (int) fields[1];
			String description = (String) fields[2];
			List<String> hashtags = new ArrayList<String>();

			final Pattern TAG_PATTERN = Pattern.compile("(?:^|\\s|[\\p{Punct}&&[^/]])(#[\\p{L}0-9-_]+)");
			Matcher m = TAG_PATTERN.matcher(description);

			while (m.find()) {
				String tag = m.group(1);
				hashtags.add(tag);
			}

			Record r = new Record(name, rating, hashtags, description);
			records.add(r);
		}
		return records;
	}

}
