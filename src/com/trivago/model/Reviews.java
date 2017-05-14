package com.trivago.model;

import java.util.Date;

public class Reviews {
	private Ratings rating;
	private String authorLocation;
	private String title;
	private String author;
	private String reviewID;
	private String content;
	private Date reviewDate;
	
	public Reviews(){};
	
	
	public Reviews(Ratings rating, String authorLocation, String title, String author, String reviewID,
			String content, Date reviewDate) {
		this.rating = rating;
		this.authorLocation = authorLocation;
		this.title = title;
		this.author = author;
		this.reviewID = reviewID;
		this.content = content;
		this.reviewDate = reviewDate;
	}
	
	public Ratings getRating() {
		return rating;
	}
	public void setRatingList(Ratings rating) {
		this.rating = rating;
	}
	public String getAuthorLocation() {
		return authorLocation;
	}
	public void setAuthorLocation(String authorLocation) {
		this.authorLocation = authorLocation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReviewID() {
		return reviewID;
	}
	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	

}
