package com.example.springboot_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hibernate.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
