package com.example.crudproject;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//ARGUMENTS of jpa repository:
//<Student, String>
//Student because that is the type we are working on
//String because that is the type of Id of student in Student.java
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
	
//	@Query("SELECT s FROM Student s WHERE s.name=?1")
	Optional<Student> findStudentByName(String name);
}
