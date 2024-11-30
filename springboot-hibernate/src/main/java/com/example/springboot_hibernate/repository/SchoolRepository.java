package com.example.springboot_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hibernate.entity.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
