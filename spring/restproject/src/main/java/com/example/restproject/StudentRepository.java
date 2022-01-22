package com.example.restproject;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//ARGUMENTS of jpa repository:
//<Student, Long>
//Student because that is the type we are working on
//Long because that is the type of Id of student in Student.java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
//	@Query("SELECT s FROM Student s WHERE s.name=?1")
	Optional<Student> findStudentByName(String name);
}
