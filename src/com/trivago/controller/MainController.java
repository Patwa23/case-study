package com.trivago.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/")
	public String showForm(){
		/*ModelMap model = new ModelMap();
				model.addAttribute("pictureName", "logo.jpg");*/		
		return "home";
	}
	
	
	
}
