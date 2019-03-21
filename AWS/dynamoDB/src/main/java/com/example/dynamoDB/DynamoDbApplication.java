package com.example.dynamoDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamoDbApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DynamoDbApplication.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		//CreateTable.createTable();
		CreateTable.getItem();
	}

}
