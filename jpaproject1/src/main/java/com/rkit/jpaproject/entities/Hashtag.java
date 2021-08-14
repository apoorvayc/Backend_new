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
		@Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
	    UUID id;
		int rating;
		String hashtagname;

		
		@Override
		public String toString() {
			return "User [id=" + id + ", rating=" + rating + ", hashtagname=" + hashtagname + "]";
		}

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
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

