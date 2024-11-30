package com.example.springboot_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hibernate.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
