package com.ashwin.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashwin.poc.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

//	List<Item> findByDistinctName
	
}
