package com.scalableservices.product.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.scalableservices.product.exception.NoCategoriesFoundException;
import com.scalableservices.product.model.Category;
import com.scalableservices.product.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
	
	@InjectMocks
	private CategoryServiceImpl categoryServiceImpl;
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@Test
	public void testGetCategory() throws NoCategoriesFoundException {
		Category category = getCategory();
		when(categoryRepository.findByCategoryId(1L)).thenReturn(category);
		
		Category response = categoryServiceImpl.getCategory(1L);
		
		assertNotNull(response);
	}
	
	private Category getCategory() {
		Category category = new Category();
		category.setCategory("ABC");
		category.setCategoryId(1L);
		return category;
	}

}
