package com.manju.online_shopping.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageContoller {
	
	@RequestMapping(value = {"/" , "/home" , "/index"})
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("greeting", "Welcome to spring web mvc");
		return model;
	}
}
