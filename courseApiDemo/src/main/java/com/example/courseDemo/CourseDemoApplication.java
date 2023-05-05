package com.example.courseDemo;

import com.example.courseDemo.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CourseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseDemoApplication.class, args);
	}

}
