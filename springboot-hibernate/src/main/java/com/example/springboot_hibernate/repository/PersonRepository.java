package com.example.springboot_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hibernate.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
