package com.example.crudproject;

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
	private final StudentService studentservice;



	@Autowired
	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@GetMapping("/student/{id}")
	String getStudent(@PathVariable String id) {
		return studentservice.getStudentById(id);
	}

	@PostMapping("/student")
	public void createStudent(@RequestBody Student student) {
		studentservice.addNewStudent(student);
	}
	
	@GetMapping("/student")
	public List<String> getStudents() {
		return studentservice.getStudents();
	}
	
	@DeleteMapping("student/{studentId}")
	public String deleteStudent(@PathVariable("studentId") String studentId) {
		return studentservice.deleteStudent(studentId);
	}
	
	@PutMapping("student/{studentId}")
	public void updateStudent(
			@PathVariable("studentId") String studentId,
			@RequestParam(required=false) String name
			) {
		studentservice.updateStudent(studentId, name);
	}
}
