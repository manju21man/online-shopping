package com.manju.shoppingBackend.dao;

import java.util.List;

import com.manju.shoppingBackend.dto.Category;

public interface CategoryDAO {

	public List<Category> list();

	public Category get(int id);
	
}
