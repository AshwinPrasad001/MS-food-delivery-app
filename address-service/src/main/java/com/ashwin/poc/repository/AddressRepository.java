package com.ashwin.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashwin.poc.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	List<Address> findByPinCode(String pinCode);
}
