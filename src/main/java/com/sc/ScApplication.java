package com.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sc.config")
public class ScApplication {
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(ScApplication.class);
		sa.setAddCommandLineProperties(false);
		sa.run(args);
	}
}
