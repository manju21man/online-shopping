package com.manju.shoppingBackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.manju.shoppingBackend.dao.CategoryDAO;
import com.manju.shoppingBackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	private static List<Category> categories = new ArrayList<>();
	
	static{
		
		Category category = new Category();
		
		category.setId(1);
		category.setName("Television");
		category.setDescription("this is some description for television!");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		category = new Category();
		
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("this is some description for Laptop!");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		category = new Category();
		
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("this is some description for Mobile!");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		// enhanced for loop
		for(Category category: categories){
			if (category.getId() == id) {
				return category;
			}
		}
		
		return null;
	}

}
