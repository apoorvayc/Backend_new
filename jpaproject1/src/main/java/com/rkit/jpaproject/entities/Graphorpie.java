package com.rkit.jpaproject.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Graphorpie {
		
	    private long noofusers;
	    private int rating;
		
		public long getNoofusers() {
			return noofusers;
		}
		public void setNoofusers(Long noofusers2) {
			this.noofusers = noofusers2;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}

} 