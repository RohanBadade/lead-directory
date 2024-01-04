package com.example.lead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.lead"})
public class LeadDirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadDirectoryApplication.class, args);
	}

}
