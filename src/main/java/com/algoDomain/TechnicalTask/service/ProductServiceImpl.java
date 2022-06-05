package com.algoDomain.TechnicalTask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algoDomain.TechnicalTask.entity.Product;
import com.algoDomain.TechnicalTask.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	List<Product> List;
	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Product> getProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		 productRepo.save(product);
		 return product;
	}

	@Override
	public void deleteProduct(int productId) {
		productRepo.deleteById(productId);
		
	}

	@Override
	public void updateProduct(Product productId) {
		productRepo.save(productId);	
	}

	@Override
	public Object getProduct(int productId) {
		return productRepo.findById(productId);
	}

}
