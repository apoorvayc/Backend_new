package com.rkit.jpaproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.rkit.jpaproject.entities.Pair;
import com.rkit.jpaproject.entities.Record;
import com.rkit.jpaproject.repository.DashboardRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DashboardService {
	
	DashboardRepository dashboardrepo = new DashboardRepository();

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Pair> getDashboardTable() {
	      Query query = (Query) entityManager.createQuery("select e.emailID,e.name,avg(r.rating) from Emp_Rating r  join Employee e on r.empId = e.id group by e.id");
	      List<Object> list = (List<Object>) query.getResultList();
	     System.out.println(list);
	      List<Pair> records = new ArrayList<Pair>();
	      for (Object h1 : list) {
	          Object[] fields = (Object[]) h1;
	          String email = (String) fields[0];
	          String name = (String) fields[1];
	          double avgrating = (double) fields[2];


	          Pair r = new Pair(email, avgrating, name);
	          records.add(r);
	      }
	      return records;
		}
	
	public List<Pair> searchemployeeindashboard(String name) {
		Query query = (Query) entityManager.createQuery("select e.emailID,e.name,avg(r.rating) from Emp_Rating r join Employee e on r.empId = e.id group by e.id having e.name like '"+name+"%'");
        List<Object> list = (List<Object>) query.getResultList();
        List<Pair> records = new ArrayList<Pair>();
        for (Object h1 : list) {
            Object[] fields = (Object[]) h1;
            String email = (String) fields[0];
            String name1 = (String) fields[1];
            double avgrating = (double) fields[2];


            Pair r = new Pair(email, avgrating, name1);
            records.add(r);
        }
        return records;
	}
	
	public List<Record> livefeed() {
		Query query = entityManager.createQuery(
				"select e.name,r.rating,r.description,r.timestamp from Emp_Rating r  join Employee e on r.empId = e.id order by timestamp(r.timestamp) desc");
		List<Object> list = (List<Object>) query.getResultList();
		List<Record> records = new ArrayList<Record>();
		for (Object h1 : list) {
			Object[] fields = (Object[]) h1;

			String name = (String) fields[0];
			int rating = (int) fields[1];
			String description = (String) fields[2];
			String t = (String) fields[3];
			
			System.out.println(name+rating+description+t); 
			
			List<String> hashtags = new ArrayList<String>();
			
			final Pattern TAG_PATTERN = Pattern.compile("(?:^|\\s|[\\p{Punct}&&[^/]])(#[\\p{L}0-9-_]+)");
			Matcher m = TAG_PATTERN.matcher(description);

			while (m.find()) {
				String tag = m.group(1);
				hashtags.add(tag);
			}

			Record r = new Record(name, rating, hashtags, description, t);
			records.add(r);
		}
		return records;
	}
	
	public List<Record> searchinratingtable(String hashtag) {
		Query query = entityManager.createQuery("select e.name,r.rating,r.description,r.timestamp from Emp_Rating r join Employee e on r.empId = e.id where r.empId in (select emp_rating_id from Hashtag where hashtagname like '"+ hashtag +"%') order by timestamp(r.timestamp) desc ");
		List<Object> list = (List<Object>) query.getResultList();
		List<Record> records = new ArrayList<Record>();
		for (Object h1 : list) {
			Object[] fields = (Object[]) h1;

			String name = (String) fields[0];
			int rating = (int) fields[1];
			String description = (String) fields[2];
			String t = (String) fields[3];
			
			System.out.println(name+rating+description+t); 
			
			List<String> hashtags = new ArrayList<String>();
			
			final Pattern TAG_PATTERN = Pattern.compile("(?:^|\\s|[\\p{Punct}&&[^/]])(#[\\p{L}0-9-_]+)");
			Matcher m = TAG_PATTERN.matcher(description);

			while (m.find()) {
				String tag = m.group(1);
				hashtags.add(tag);
			}

			Record r = new Record(name, rating, hashtags, description, t);
			records.add(r);
		}
		return records;
	}


}
