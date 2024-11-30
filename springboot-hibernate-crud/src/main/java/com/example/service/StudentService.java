package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public Student saveStudent(Student s) {
		return studentRepo.save(s);
	}
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	public Student getStudentByRollNo(int rollNo) {
        return studentRepo.findById(rollNo).orElse(null);
    }
	
	public Student updateStudent(int rollNo, Student updatedStudent) {
		Optional<Student> currentStudent = studentRepo.findById(rollNo);
		if (currentStudent.isPresent()) {
            Student student = currentStudent.get();
            student.setAddress(updatedStudent.getAddress());
            student.setAadhaar(updatedStudent.getAadhaar());
            student.setSubjects(updatedStudent.getSubjects());
            return studentRepo.save(student);
        } else {
            return null;
        }
	}
	
	public void deleteStudent(int rollNo) {
        studentRepo.deleteById(rollNo);
    }
	
}
