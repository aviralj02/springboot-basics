package com.example.springboot_hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AadhaarCard {
	
	@Id
	private Long aadhaarNum;
	
	@OneToOne(mappedBy = "ac")
	private Person p;
	private String address;
	
	public Long getAadhaarNum() {
		return aadhaarNum;
	}
	public void setAadhaarNum(Long aadhaarNum) {
		this.aadhaarNum = aadhaarNum;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
