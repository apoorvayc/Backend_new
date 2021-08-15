package com.rkit.jpaproject.entities;

import java.util.List;

public class Record {

	private String empName;
	private int rating;
	private List<String> hashtag;
	private String desc;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<String> getHashtag() {
		return hashtag;
	}

	public void setHashtag(List<String> hashtag) {
		this.hashtag = hashtag;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Record(String empName, int rating, List<String> hashtag, String desc) {
		super();
		this.empName = empName;
		this.rating = rating;
		this.hashtag = hashtag;
		this.desc = desc;
	}

	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

}
