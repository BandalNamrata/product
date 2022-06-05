package com.algoDomain.TechnicalTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algoDomain.TechnicalTask.entity.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
