package com.example.jpademo.repository;

import com.example.jpademo.entity.Guardian;
import com.example.jpademo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Guard;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("abj2@gmail.com")
                .firstName("Temp")
                .lastName("name")
//                .guardianEmail("parent@gmail.com")
//                .guardianName("guardian_temo")
//                .guardianMobile("1111111111")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("temp@user.com")
                .name("User")
                .mobile("9988776655")
                .build();

        Student student = Student.builder()
                .firstName("Chandan")
                .emailId("cbansal82@gmail.com")
                .lastName("Bansal")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("student list: "+studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Chandan");
        System.out.println("Result by First name: "+ students);
    }

    @Test
    public void findByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("an");
        System.out.println("Result by First name containing: "+ students);

    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("user");
        System.out.println(students);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "UserChild",
                "cbansal82@gmail.com"
        );
    }
 }