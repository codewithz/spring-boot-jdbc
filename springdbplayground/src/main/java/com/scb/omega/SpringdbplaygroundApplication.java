package com.scb.omega;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scb.omega.service.impl.FileStorageService;

@SpringBootApplication
public class SpringdbplaygroundApplication implements CommandLineRunner {
	
	@Resource
	FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringdbplaygroundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//storageService.init();
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	

}
