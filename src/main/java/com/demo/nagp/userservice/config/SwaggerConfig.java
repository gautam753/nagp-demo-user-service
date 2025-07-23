package com.demo.nagp.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI api() {
		return new OpenAPI().info(new Info().title("User CRUD API").version("1.0")
				.description("Demo Spring Boot Microservice with PostgreSQL, Docker, Swagger, and API Key security"));
	}
}
