package com.ashwin.poc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashwin.poc.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findByCategoryName(String categoryName);
	Optional<Category> deleteByCategoryName(String categoryName);
	
}
