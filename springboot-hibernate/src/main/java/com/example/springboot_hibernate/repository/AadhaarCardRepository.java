package com.example.springboot_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hibernate.entity.AadhaarCard;

public interface AadhaarCardRepository extends JpaRepository<AadhaarCard, Integer> {

}
