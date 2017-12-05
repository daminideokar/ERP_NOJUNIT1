package com.bti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

/**
 * Name of Project: BTI
 * Description: Service Bti
 * Created on: NOVEMBER 1, 2017
 * Modified on:
 * @author goodtech
 * version :
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Bti {

	public static void main(String[] args) {
		SpringApplication.run(Bti.class, args);
	}
}