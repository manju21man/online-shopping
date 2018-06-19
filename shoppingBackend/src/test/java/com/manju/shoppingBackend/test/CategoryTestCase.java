package com.manju.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.manju.shoppingBackend.dao.CategoryDAO;
import com.manju.shoppingBackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.manju.shoppingBackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("this is some description for television!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("successfully added a category inside the table!",true,categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category = categoryDAO.get(1);
		assertEquals("successfully fetched a single category from the table!","Television",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("successfully Updated a name of category in the table!",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		category = categoryDAO.get(1);
		assertEquals("successfully deleted a category in the table!",true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory(){
		assertEquals("successfully fetched list of category from the table!",3,categoryDAO.list().size());
	}*/
	
	@Test
	public void teseCRUDCategory(){
		
		// add operation
		category = new Category();
		
		category.setName("Television");
		category.setDescription("this is some description for television!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("successfully added a category inside the table!",true,categoryDAO.add(category));
	
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("this is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("successfully added a category inside the table!",true,categoryDAO.add(category));
	
		// fetching and updating the category
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("successfully Updated a name of category in the table!",true,categoryDAO.update(category));
	
		// deleting the category
		assertEquals("successfully deleted a category in the table!",true,categoryDAO.delete(category));
		
		// fetching list
		assertEquals("successfully fetched list of category from the table!",1,categoryDAO.list().size());
	}
}
