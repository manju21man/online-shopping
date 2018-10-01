package com.manju.online_shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manju.online_shopping.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView showCart(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "User cart");
		mv.addObject("userClickShowCart", "true");
		mv.addObject("cartLines", cartService.getCartLines());
		
		return mv;
	}
}
