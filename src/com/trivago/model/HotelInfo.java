package com.trivago.model;

public class HotelInfo {
	
	private String name;
	private String hotelURL;
	private String price;
	private String address;
	private String hotelID;
	private String imgURL;
	private int positive=0;
	private int negative=0;
	private double intensifier=0;
	
	public HotelInfo(String name, String hotelURL, String price, String address, String hotelID, String imgURL) {
		this.name = name;
		this.hotelURL = hotelURL;
		this.price = price;
		this.address = address;
		this.hotelID = hotelID;
		this.imgURL = imgURL;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHotelURL() {
		return hotelURL;
	}
	public void setHotelURL(String hotelURL) {
		this.hotelURL = hotelURL;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	@Override
	public String toString() {
		return "HotelInfo [positive=" + positive + ", negative=" + negative + ", intensifier=" + intensifier + "]";
	}

	public int getPositive() {
		return positive;
	}

	public void setPositive(int positive) {
		this.positive = positive;
	}

	public int getNegative() {
		return negative;
	}

	public void setNegative(int negative) {
		this.negative = negative;
	}

	public double getIntensifier() {
		return intensifier;
	}

	public void setIntensifier(double intensifier) {
		this.intensifier = intensifier;
	}
	
}
