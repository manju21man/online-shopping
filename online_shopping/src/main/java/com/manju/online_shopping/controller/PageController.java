package com.manju.online_shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/" , "/home" , "/index"})
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Home");
		model.addObject("userClickHome", true);
		return model;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "About Us");
		model.addObject("userClickAbout", true);
		return model;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Contact Us");
		model.addObject("userClickContact", true);
		return model;
	}
}
