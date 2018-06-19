package com.manju.shoppingBackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.manju.shoppingBackend.dto.Category;

public interface CategoryDAO {

	public Category get(int id);
	
	public List<Category> list();

	public boolean add(Category category);
	
	public boolean update(Category category);
	
	public boolean delete(Category category);
	
}
