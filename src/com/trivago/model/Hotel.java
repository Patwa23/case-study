package com.trivago.model;

import java.util.List;

public class Hotel {
	
	private List<Reviews> review;
	private HotelInfo hotelInfo;
	
	@Override
	public String toString() {
		return "HotelReview [review=" + review + ", hotelInfo=" + hotelInfo + "]";
	}
	public List<Reviews> getReview() {
		return review;
	}
	public void setReview(List<Reviews> review) {
		this.review = review;
	}
	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}
	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
	
	

}
