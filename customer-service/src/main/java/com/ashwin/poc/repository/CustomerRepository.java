package com.ashwin.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashwin.poc.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
