package com.algoDomain.TechnicalTask.service;

import java.util.List;

import com.algoDomain.TechnicalTask.entity.Product;

public interface ProductService {

	public List<Product> getProduct();

	public Product addProduct(Product product);

	public void deleteProduct(int productId);

	public void updateProduct(Product productId);

	public Object getProduct(int productId);

}
