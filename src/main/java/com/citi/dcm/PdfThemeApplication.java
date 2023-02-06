package com.citi.dcm;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfThemeApplication {
	@Value("${spring.datasource.password}")
	private char[] password;
	
	@PostConstruct
	private void init() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$ " + new String(password));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PdfThemeApplication.class, args);
	}
}
