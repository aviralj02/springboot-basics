package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AadhaarCard;
import com.example.repository.AadhaarRepository;

@Service
public class AadhaarService {
	
	@Autowired
	private AadhaarRepository aadhaarRepo;
	
	public AadhaarCard getAadhaarCardById(int id) {
		return aadhaarRepo.findById(id).orElse(null);
	}
	
	public List<AadhaarCard> getAllAadhaarCards(){
		return aadhaarRepo.findAll();
	}
	
	public AadhaarCard saveAadhaar(AadhaarCard card) {
		return aadhaarRepo.save(card);
	}
	
	public void deleteAadhaar(int id) {
		aadhaarRepo.deleteById(id);
	}
	
	public AadhaarCard updateAadhaar(int id, AadhaarCard newDetails) {
		Optional<AadhaarCard> currentAadhaar = aadhaarRepo.findById(id);
		
		if (currentAadhaar.isPresent()) {
			AadhaarCard aadhaar = currentAadhaar.get();
			aadhaar.setNum(newDetails.getNum());
			
			return aadhaarRepo.save(aadhaar);
		}
		return null;
	}
	
}
