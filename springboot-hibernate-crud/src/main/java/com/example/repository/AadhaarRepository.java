package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AadhaarCard;

public interface AadhaarRepository extends JpaRepository<AadhaarCard, Integer>{

}
