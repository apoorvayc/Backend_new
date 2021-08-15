package com.rkit.jpaproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Pair {

    public Pair(String email2, double avgrating, String name2) {
		this.email = email2;
		this.rating = avgrating;
		this.name = name2;
		
	}

	@Override
    public String toString() {
        return "Pair{" +
                "email='" + email + '\'' +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                '}';
    }

    String email;
    double rating;
    String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
