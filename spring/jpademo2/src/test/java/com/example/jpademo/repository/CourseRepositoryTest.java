package com.example.jpademo.repository;

import com.example.jpademo.entity.Course;
import com.example.jpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courseList =
                courseRepository.findAll();
        System.out.println("Course List : " + courseList);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Mamta")
                .lastName("Thakur")
                .build();
        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords)
                                .getTotalElements();
        long totalPages= courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalPages();
        System.out.println("totalPages : " + totalPages);
        System.out.println("totalElements : " + totalElements);
        System.out.println("Courses : " + courses);
    }

    @Test
    public void findAllWithSorting() {
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));
        List<Course> courses =
                courseRepository.findAll(sortByTitle)
                        .getContent();
        System.out.println("totalPages : " + courses);
    }
}