package com.harbourspace.springapplicationforcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringapplicationforcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringapplicationforcloudApplication.class, args);
	}

}
