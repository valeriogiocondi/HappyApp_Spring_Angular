package com.happyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan( basePackages = {"Model"} )
public class HappyAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(HappyAppApplication.class, args);
		System.out.print("Hello!");
	}
}