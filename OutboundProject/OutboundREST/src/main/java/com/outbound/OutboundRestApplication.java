package com.outbound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OutboundRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutboundRestApplication.class, args);
	}

	 
		@Bean
		  public PasswordEncoder configurePasswordEncoder() {
		    return new BCryptPasswordEncoder();
		  }
	  
}
