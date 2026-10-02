package com.example.ddl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;


@EnableBatchProcessing
@SpringBootApplication

public class DdlApplication {


	
	public static void main(String[] args) {
		System.out.println("Arguments:");

    for (String arg : args) {
        System.out.println(arg);
    }
		SpringApplication.run(DdlApplication.class, args);
	}

}
