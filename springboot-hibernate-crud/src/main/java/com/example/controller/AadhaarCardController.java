package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AadhaarCard;
import com.example.service.AadhaarService;

@RestController
@RequestMapping("/aadhaar")
public class AadhaarCardController {
	
	@Autowired
	private AadhaarService aadhaarService;
	
	@GetMapping
	public List<AadhaarCard> getAllAadhaar(){
		return aadhaarService.getAllAadhaarCards();
	}
	
	@GetMapping("/{id}")
	public AadhaarCard getAadhaarById(@PathVariable int id) {
		return aadhaarService.getAadhaarCardById(id);
	}
	
	@PostMapping
	public AadhaarCard createAadhaar(@RequestBody AadhaarCard aadhaar) {
		return aadhaarService.saveAadhaar(aadhaar);
	}
	
	@PutMapping("/{id}")
	public AadhaarCard updateAadhaarCard(@PathVariable int id, @RequestBody AadhaarCard newDetails) {
		return aadhaarService.updateAadhaar(id, newDetails);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAadhaarCard(@PathVariable int id) {
		deleteAadhaarCard(id);
	}
	
}
