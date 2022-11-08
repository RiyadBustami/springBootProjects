package com.riyadbusttami.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyadbusttami.productsandcategories.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	public List<Product> findAll();
}
