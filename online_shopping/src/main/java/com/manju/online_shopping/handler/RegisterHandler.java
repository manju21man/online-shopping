package com.manju.online_shopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manju.online_shopping.model.RegisterModel;
import com.manju.shoppingBackend.dao.UserDAO;
import com.manju.shoppingBackend.dto.Address;
import com.manju.shoppingBackend.dto.Cart;
import com.manju.shoppingBackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing){
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model){
		String transitionValue = "success";
		
		//fetch the user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		// save the user
		userDAO.addUser(user);
		
		//get address
		Address billing = model.getBilling();
		//billing.setUser(user);
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
}
