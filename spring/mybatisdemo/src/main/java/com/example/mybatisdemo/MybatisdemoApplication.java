package com.example.mybatisdemo;

import com.example.mybatisdemo.model.Users;
import org.apache.ibatis.type.MappedTypes;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MappedTypes(Users.class)
@MapperScan("com.example.mybatisdemo.mappers")
@SpringBootApplication
public class MybatisdemoApplication {

	static final Logger logger = Logger.getLogger(String.valueOf(MybatisdemoApplication.class));

	public static void main(String[] args) {
		SpringApplication.run(MybatisdemoApplication.class, args);
		ConsoleAppender consoleAppender = new ConsoleAppender();
		consoleAppender.setThreshold(Level.INFO);
		consoleAppender.setLayout(new PatternLayout("%d [%p|%c|%C{1}] %m%n"));
		consoleAppender.activateOptions();
		Logger.getRootLogger().addAppender(consoleAppender);
//		logger.info("Testing Logger" );
		logger.error(
				"Test Fail Error Sample",
				new Exception()
		);
		try {

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
