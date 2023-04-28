package com.scalableservices.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scalableservices.product.dto.ProductResponse;
import com.scalableservices.product.dto.ProductsList;
import com.scalableservices.product.exception.NoCategoriesFoundException;
import com.scalableservices.product.exception.NoProductsFoundException;
import com.scalableservices.product.model.Category;
import com.scalableservices.product.model.Product;
import com.scalableservices.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;

	@Override
	public ProductResponse getProducts(Long categoryId) throws NoCategoriesFoundException, NoProductsFoundException {
		ProductResponse productResponse = new ProductResponse();
		List<ProductsList> productsLists = new ArrayList<>();
		Category category = categoryService.getCategory(categoryId);
		List<Product> products = productRepository.findByCategory(category);
		if(products.isEmpty()) {
			throw new NoProductsFoundException("No Products Found for Category");
		}
		products.forEach(product -> {
			ProductsList productsList = new ProductsList();
			productsList.setProduct(product.getProduct());
			productsList.setProductId(product.getProductId());
			productsLists.add(productsList);
		});
		productResponse.setCategory(category.getCategory());
		productResponse.setCategoryId(categoryId);
		productResponse.setProducts(productsLists);
		return productResponse;
	}

}
