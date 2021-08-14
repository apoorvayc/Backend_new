package com.rkit.jpaproject.entities;

import java.util.Date;


import java.sql.Timestamp;  
import java.time.Instant;  


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Emp_Rating {

	int rating;

	String description;
	
	@Column(name = "Timestamp")
	
	String timestamp;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long empRatingId;

	long empId;

	
	public Emp_Rating(int rating, String description, long empRatingId, long empId,String timestamp) {
		super();
		this.rating = rating;
		this.description = description;
		this.empRatingId = empRatingId;
		this.empId = empId;
		 
		this.timestamp = this.timestamp;
		System.out.println("\nfsdfds\n");
	}

	public Emp_Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getEmpRatingId() {
		return empRatingId;
	}

	public void setEmpRatingId(long empRatingId) {
		this.empRatingId = empRatingId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String st) {
		
		this.timestamp = st;
		System.out.println("\nfsdfds\n");
	}
	
	

}
