package com.manju.shoppingBackend.dao;

import java.util.List;

import com.manju.shoppingBackend.dto.Address;
import com.manju.shoppingBackend.dto.Cart;
import com.manju.shoppingBackend.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);
	User getByEmail(String email);

	//add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	//update a cart
	boolean updateCart(Cart cart);
}
