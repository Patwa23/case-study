package com.trivago.model;

public class Ratings {
	private int service;
	private int cleanliness;
	private int businessservice;
	private int checkInOrFrontDesk;
	private float overall;
	private int value;
	private int rooms;
	private int location;
	
	
	public Ratings(int service, int cleanliness, int businessservice, int checkInOrFrontDesk, float overall, int value,
			int rooms, int location) {
		this.service = service;
		this.cleanliness = cleanliness;
		this.businessservice = businessservice;
		this.checkInOrFrontDesk = checkInOrFrontDesk;
		this.overall = overall;
		this.value = value;
		this.rooms = rooms;
		this.location = location;
	}
	
	public int getService() {
		return service;
	}
	public void setService(int service) {
		this.service = service;
	}
	public int getCleanliness() {
		return cleanliness;
	}
	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}
	public int getBusinessservice() {
		return businessservice;
	}
	public void setBusinessservice(int businessservice) {
		this.businessservice = businessservice;
	}
	public int getCheckInOrFrontDesk() {
		return checkInOrFrontDesk;
	}
	public void setCheckInOrFrontDesk(int checkInOrFrontDesk) {
		this.checkInOrFrontDesk = checkInOrFrontDesk;
	}
	public float getOverall() {
		return overall;
	}
	public void setOverall(float overall) {
		this.overall = overall;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	
	
	
	
}
