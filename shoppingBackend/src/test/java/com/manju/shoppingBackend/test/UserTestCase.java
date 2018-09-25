package com.manju.shoppingBackend.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manju.shoppingBackend.dao.UserDAO;
import com.manju.shoppingBackend.dto.Address;
import com.manju.shoppingBackend.dto.Cart;
import com.manju.shoppingBackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.manju.shoppingBackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*@Test
	public void testAdd(){
		
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234567890");
		user.setRole("USER");
		user.setPassword("123456");
		
		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B, ABC Nagar, Bangalore");
		address.setAddressLineTwo("near abc store");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560066");
		address.setBilling(true);

		// link the user with the address using user id
		address.setUserId(user.getId());
		
		// add the address
		assertEquals("Failed to add Address!", true, userDAO.addAddress(address));
			
		if(user.getRole().equals("USER")){
			
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			// add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			// Add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("200/A, LMN Nagar, Bangalore");
			address.setAddressLineTwo("near lmn store");
			address.setCity("Bangalore");
			address.setState("Karnataka");
			address.setCountry("India");
			address.setPostalCode("560001");
			address.setShipping(true);
			
			// link it with the user
			address.setUserId(user.getId());
			
			// add the address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
			
		}*/
		
	/*@Test
	public void testAdd(){
		
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234567890");
		user.setRole("USER");
		user.setPassword("123456");
		
		if(user.getRole().equals("USER")){
			
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			//attach cart with user
			user.setCart(cart);
		}
		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
	}*/

	/*@Test
	public void testUpdateCart(){
		
		// fetch the user by its id
		 user = userDAO.getByEmail("hr@gmail.com");
		 
		//get the cart of the user
		 cart = user.getCart();
		 
		 cart.setGrandTotal(5000);
		 cart.setCartLines(2);
		 
		 assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
	}*/
	
	/*@Test
	public void testAddAddress(){
		
		// we need to add user
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234567890");
		user.setRole("USER");
		user.setPassword("123456");
		
		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		// we are going to add address
		address = new Address();
		address.setAddressLineOne("101/B, ABC Nagar, Bangalore");
		address.setAddressLineTwo("near abc store");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560066");
		address.setBilling(true);
		
		// attached user to the address
		address.setUserId(user.getId());
		
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		// we are also going to add shipping address
		address = new Address();
		address.setAddressLineOne("200/A, LMN Nagar, Bangalore");
		address.setAddressLineTwo("near lmn store");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("560001");
		address.setShipping(true);
		
		// attached user to the address
		address.setUserId(user.getId());
				
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		
	}*/
	
	@Test
	public void testAddAddress(){
		
		user = userDAO.getByEmail("hr@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("200/A, ABC Nagar, Hassan");
		address.setAddressLineTwo("near abc store");
		address.setCity("Hassan");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("573201");
		address.setShipping(true);
		
		// attached user to the address
		address.setUserId(user.getId());
				
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		
		
	}
	
	/*@Test
	public void testGetAddresses(){
		
		user = userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("Failed to fetch the list of shipping address and size doesn't match!",2, 
						userDAO.listShippingAddresses(1).size());
		
		assertEquals("Failed to fetch the billing address!", "Bangalore", 
				userDAO.getBillingAddress(1).getCity());
	}*/
}

