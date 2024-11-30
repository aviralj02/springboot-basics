package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNo;

	@OneToOne(cascade = CascadeType.ALL)
	private AadhaarCard aadhaar;
	
	private String address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Subject> subjects;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public AadhaarCard getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(AadhaarCard aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
