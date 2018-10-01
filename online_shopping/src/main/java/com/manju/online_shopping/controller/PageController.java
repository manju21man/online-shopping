package com.manju.online_shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manju.online_shopping.exception.ProductNotFoundException;
import com.manju.shoppingBackend.dao.CategoryDAO;
import com.manju.shoppingBackend.dao.ProductDAO;
import com.manju.shoppingBackend.dto.Category;
import com.manju.shoppingBackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/" , "/home" , "/index"})
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
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
	
	/*
	 * Viewing a single product
	 * */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if (product == null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
	/* having similar mapping to our flow id */
	@RequestMapping(value = "/register")
	public ModelAndView register(){
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Register");
		return model;
	}
	
	/* Login */
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout",required=false) String logout){
		ModelAndView model = new ModelAndView("login");
		if(error!=null){
			model.addObject("message", "Invalid Username and Password!");
		}
		if(logout!=null){
			model.addObject("logout", "You have been successfully logged out!");
		}
		model.addObject("title", "Login");
		return model;
	}
	
	/* access- denied  */
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied(){
		ModelAndView model = new ModelAndView("error");
		model.addObject("title", "403 - Access Deied");
		model.addObject("errorTitle", "Aha! Caught You.");
		model.addObject("errorDescription", "You are not authorized to view this page!");
		return model;
	}
	
	/* Logout */
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
}
