package com.scalableservices.product.dto;

import java.util.List;

public class ProductResponse {
	
	private Long categoryId;
	private String category;
	
	private List<ProductsList> products;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ProductsList> getProducts() {
		return products;
	}

	public void setProducts(List<ProductsList> products) {
		this.products = products;
	}
	
	
}
