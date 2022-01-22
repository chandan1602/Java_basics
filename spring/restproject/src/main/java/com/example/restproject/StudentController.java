package com.example.restproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	
//	@PostMapping("/student/create")
//	public Student createStudent(@RequestBody Student student) {
//		return studentRepository.save(student);
//	}
	
	@GetMapping("/student/{id}")
	Student getStudent(@PathVariable Long id) {
		return studentRepository.findById(id).get();
	}
	
	private final StudentService studentservice;
	
	@Autowired
	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}
	
	@PostMapping("/student/create")
	public void createStudent(@RequestBody Student student) {
		studentservice.addNewStudent(student);
	}
	
	@GetMapping("/student")
	public List<Student> getStudents() {
		return studentservice.getStudents();
	}
	
	@DeleteMapping("student/delete/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentservice.deleteStudent(studentId);
	}
	
	@PutMapping("student/edit/{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required=false) String name
			) {
		studentservice.updateStudent(studentId, name);
	}
}
