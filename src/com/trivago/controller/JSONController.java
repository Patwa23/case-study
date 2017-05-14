package com.trivago.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trivago.model.Hotel;
import com.trivago.service.CompareHotelService;
import com.trivago.service.ReadJSONFile;

@Controller
@RequestMapping("/home")
public class JSONController {
	
	ReadJSONFile reviewFile = new ReadJSONFile();
	List<Hotel> list = reviewFile.readAllFile();
	CompareHotelService service=new CompareHotelService();
	List<Hotel> comparedHotelList=service.getComparedHotelList();;

	@RequestMapping("/viewAllHotel")
	public String viewHotel(Model model) {
		model.addAttribute("hotelList",list);
		model.addAttribute("comparedHotelList",comparedHotelList);
		model.addAttribute("message","Only 2 hotels allowed");
		return "viewAllHotel";
	}

	@RequestMapping(value = "/hoteldetail/{id}")
	public ModelAndView hotelDetails(@PathVariable int id) {
		Hotel hotel = list.stream().filter(h -> h.getHotelInfo().getHotelID().equals(String.valueOf(id))).findAny().get();
		return new ModelAndView("hotelDetails", "hotel", hotel);
	}
	
	@RequestMapping(value = "/addhoteltocompare/{id}")
	public ModelAndView addHotelToCompare(@PathVariable int id) {
		Hotel hotel = list.stream().filter(h -> h.getHotelInfo().getHotelID().equals(String.valueOf(id))).findAny().get();
		String msg=service.addHotelForCompare(hotel);
		return new ModelAndView("redirect:/home/viewAllHotel");  
	}
	
	@RequestMapping(value = "/removehoteltocompare/{id}")
	public ModelAndView removehoteltocompare(@PathVariable int id) {
		Hotel hotel = list.stream().filter(h -> h.getHotelInfo().getHotelID().equals(String.valueOf(id))).findAny().get();
		String msg=service.removeHotelForCompare(hotel);
		return new ModelAndView("redirect:/home/viewAllHotel");  
	}
	
	@RequestMapping("/comparehotel")
	public String compareHotel(Model model) {
		model.addAttribute("comparedHotelList",comparedHotelList);
		return "compareHotel";
	}
	
	
}
