package com.example.springboot_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_hibernate.entity.IndigoFlight;

public interface IndigoFlightRepository extends JpaRepository<IndigoFlight, Integer> {

}
