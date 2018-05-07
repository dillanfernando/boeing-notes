package com.boeing.assignment.notetaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NoteTakerApplication extends SpringBootServletInitializer {

	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(NoteTakerApplication.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(NoteTakerApplication.class, args);
	}
}
