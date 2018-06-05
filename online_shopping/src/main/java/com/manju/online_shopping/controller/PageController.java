package com.manju.online_shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manju.shoppingBackend.dao.CategoryDAO;
import com.manju.shoppingBackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/" , "/home" , "/index"})
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Home");
		
		// Passing the list of categories
		model.addObject("categories", categoryDAO.list());
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
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "All Products");
		
		// Passing the list of categories
		model.addObject("categories", categoryDAO.list());
		
		model.addObject("userClickAllProducts", true);
		return model;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		ModelAndView model = new ModelAndView("page");
		
		// categoryDAO to fetch single category
		
		Category category = null;
		category = categoryDAO.get(id);
		
		model.addObject("title", category.getName());
		
		// Passing the list of categories
		model.addObject("categories", categoryDAO.list());
		
		// Passing the single category object
		model.addObject("category", category);
		
		model.addObject("userClickCategoryProducts", true);
		return model;
	}
}
