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

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{rollNo}")
    public Student getStudentByRollNo(@PathVariable int rollNo) {
        return studentService.getStudentByRollNo(rollNo);
    }

    @PutMapping("/{rollNo}")
    public Student updateStudent(@PathVariable int rollNo, @RequestBody Student studentDetails) {
        return studentService.updateStudent(rollNo, studentDetails);
    }

    @DeleteMapping("/{rollNo}")
    public void deleteStudent(@PathVariable int rollNo) {
        studentService.deleteStudent(rollNo);
    }
}
