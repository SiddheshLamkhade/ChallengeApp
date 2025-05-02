package com.example.ChallengeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeAppApplication.class, args);
		System.out.println("This app is made to deal with monthly challenges...");
	}
}
