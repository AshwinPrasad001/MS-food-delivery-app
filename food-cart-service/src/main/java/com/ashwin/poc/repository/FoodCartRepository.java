package com.ashwin.poc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashwin.poc.entity.FoodCart;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer> {

	Optional<FoodCart> findByCustomerId(Integer customerId);
}
