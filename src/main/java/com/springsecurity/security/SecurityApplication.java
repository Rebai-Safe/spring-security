package com.springsecurity.security;

import com.springsecurity.security.services.CustomUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);

		CustomUserService srv1 = new CustomUserService();
		CustomUserService srv2 = new CustomUserService();
		System.out.println(srv1.getClass()+ " "+srv2.getClass());
	}

}
