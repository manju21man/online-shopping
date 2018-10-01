package com.manju.online_shopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manju.online_shopping.model.UserModel;
import com.manju.shoppingBackend.dao.CartLineDAO;
import com.manju.shoppingBackend.dto.Cart;
import com.manju.shoppingBackend.dto.CartLine;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession httpSession;
	
	/*
	 * returns the cart of the user who has loggd in
	 */
	private Cart getCart(){
		return ((UserModel)httpSession.getAttribute("userModel")).getCart();
	}
	
	/*
	 * returns the entire cartLines
	 */
	public List<CartLine> getCartLines(){
		return cartLineDAO.list(this.getCart().getId());
		
	}
	
}
