package com.ashwin.poc.bill_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashwin.poc.bill_service.entity.BillEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Integer> {

}
