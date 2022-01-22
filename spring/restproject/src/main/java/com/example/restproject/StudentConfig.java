package com.example.restproject;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args -> {
			Student new1 = new Student(
					"TempUser1",
					22,
					"Muktsar"
					);
			
			Student new2 = new Student(
					"TempUser2",
					23,
					"Bathinda"
					);
			repository.saveAll(
					List.of(new1, new2));
		};
		
	}
}
