package com.example.SMDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SMDemo.model.PolicyDO;

public interface SMRepository extends JpaRepository<PolicyDO, Long> {

}
