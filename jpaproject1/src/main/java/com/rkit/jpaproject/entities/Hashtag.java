package com.rkit.jpaproject.entities;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hashtag {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    int id;
		int rating;
		String hashtagname;
		int emp_rating_id;
		
		public Hashtag(int i, int j, String string, int k) {
			// TODO Auto-generated constructor stub
			this.id=i;
			this.hashtagname=string;
			this.rating=j;
			this.emp_rating_id=k;
			
		}

		public Hashtag() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public int hashCode() {
			return Objects.hash(emp_rating_id, hashtagname, id, rating);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Hashtag other = (Hashtag) obj;
			return emp_rating_id == other.emp_rating_id && Objects.equals(hashtagname, other.hashtagname)
					&& id == other.id && rating == other.rating;
		}

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

