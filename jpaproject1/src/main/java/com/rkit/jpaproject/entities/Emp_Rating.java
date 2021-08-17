package com.rkit.jpaproject.entities;

import java.util.Date;
import java.util.Objects;
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
	int empRatingId;

	int empId;

	
	public Emp_Rating(int rating, String description, int empRatingId, int empId,String timestamp) {
		super();
		this.rating = rating;
		this.description = description;
		this.empRatingId = empRatingId;
		this.empId = empId;
		 
		this.timestamp =timestamp;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, empId, empRatingId, rating, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp_Rating other = (Emp_Rating) obj;
		return Objects.equals(description, other.description) && empId == other.empId
				&& empRatingId == other.empRatingId && rating == other.rating
				&& Objects.equals(timestamp, other.timestamp);
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

	public int getEmpRatingId() {
		return empRatingId;
	}

	public void setEmpRatingId(int empRatingId) {
		this.empRatingId = empRatingId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String st) {
		
		this.timestamp = st;
		System.out.println("\nfsdfds\n");
	}
	
	

}
