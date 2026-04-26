package com.crud.crud_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
		System.out.println("hello world") ;
		int number = 10 ;
		for (int i = 1; i <= number ; i++) {
			System.out.println(i) ;
		}
	}
}
