package com.rkit.jpaproject.entities;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Hashtag {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    int id;
		int rating;
		String hashtagname;
		int emp_rating_id;
		
		public int getEmp_rating_id() {
			return emp_rating_id;
		}

		public void setEmp_rating_id(int emp_rating_id) {
			this.emp_rating_id = emp_rating_id;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", rating=" + rating + ", hashtagname=" + hashtagname + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getHashtagname() {
			return hashtagname;
		}

		public void setHashtagname(String hashtagname) {
			this.hashtagname = hashtagname;
		}


		
	}

