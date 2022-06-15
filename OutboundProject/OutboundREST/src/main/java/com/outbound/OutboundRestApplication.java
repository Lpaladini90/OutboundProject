package com.outbound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OutboundRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutboundRestApplication.class, args);
	}

	 
//	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//	    return application.sources(OutboundRestApplication.class);
//	  }
//	
//	  
//		@Bean
//		  public PasswordEncoder configurePasswordEncoder() {
//		    return new BCryptPasswordEncoder();
//		  }
//	  
}
