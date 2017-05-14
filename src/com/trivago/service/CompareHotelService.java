package com.trivago.service;

import java.util.ArrayList;
import java.util.List;

import com.trivago.model.Hotel;

public class CompareHotelService {
	
	List<Hotel> list=new ArrayList<Hotel>();
	
	public List<Hotel> getComparedHotelList() {		
		return list;
	}
	
	public String addHotelForCompare(Hotel hotel){
		list.add(hotel);		
		return "successfully added";
	}
	
	public String removeHotelForCompare(Hotel hotel){
		list.remove(hotel);		
		return "successfully remove";
	}
	
}
