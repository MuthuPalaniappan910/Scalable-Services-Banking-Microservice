package com.scalableservices.product.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.scalableservices.product.dto.ProductResponse;
import com.scalableservices.product.exception.NoCategoriesFoundException;
import com.scalableservices.product.exception.NoProductsFoundException;
import com.scalableservices.product.model.Category;
import com.scalableservices.product.model.Product;
import com.scalableservices.product.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private CategoryService categoryService;
	
	@InjectMocks
	private ProductServiceImpl productservice;
	
	@Test
	public void testGetProducts() throws NoCategoriesFoundException, NoProductsFoundException {
		Category category = getCategory();
		List<Product> products = getProducts(category);
		when(categoryService.getCategory(1L)).thenReturn(category);
		when(productRepository.findByCategory(category)).thenReturn(products);
		
		ProductResponse response = productservice.getProducts(1L);
		
		assertNotNull(response);
	}

	private List<Product> getProducts(Category category) {
		List<Product> products = new ArrayList();
		Product product = new Product();
		product.setProduct("qwe");
		product.setProductId(1L);
		product.setCategory(category);
		products.add(product);
		return products;
	}

	private Category getCategory() {
		Category category = new Category();
		category.setCategory("ABC");
		category.setCategoryId(1L);
		return category;
	}

}
