package com.manju.shoppingBackend.dao;

import java.util.List;

import com.manju.shoppingBackend.dto.Cart;
import com.manju.shoppingBackend.dto.CartLine;

public interface CartLineDAO {
	
	/*
	 * the common methods from previously coded one
	 */
	
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	/*
	 * Other business methods related to the cart lines
	 */
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	/*
	 * update a cart
	 */
	public boolean updateCart(Cart cart);
	
}
