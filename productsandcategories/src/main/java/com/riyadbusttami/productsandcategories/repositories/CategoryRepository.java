package com.riyadbusttami.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyadbusttami.productsandcategories.models.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	public List<Category> findAll();
}
