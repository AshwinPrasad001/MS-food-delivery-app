package com.ashwin.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashwin.poc.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
