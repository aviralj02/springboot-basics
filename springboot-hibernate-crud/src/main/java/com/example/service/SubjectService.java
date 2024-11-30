package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Subject;
import com.example.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	public List<Subject> getAllSubjects(){
		return subjectRepo.findAll();
	}
	
	public Subject getSubjectbyId(int id) {
		return subjectRepo.findById(id).orElse(null);
	}
	
	public Subject saveSubject(Subject subject) {
		return subjectRepo.save(subject);
	}
	
	public Subject updateSubject(int id, Subject updatedSubject) {
		Optional<Subject> currentSubject = subjectRepo.findById(id);
		if (currentSubject.isPresent()) {
			Subject subject = currentSubject.get();
			subject.setName(updatedSubject.getName());
			
			return 	subjectRepo.save(subject);
		}
		return null;
	}
	
	public void deleteSubject(int id) {
		subjectRepo.deleteById(id);
	}
}
