package com.demo.nagp.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI api() {
		return new OpenAPI()
				.info(new Info().title("user-service").version("1.0")
						.description("Demo Spring Boot Microservice with PostgreSQL, Docker, Swagger, and API Key security")
				).addSecurityItem(new SecurityRequirement().addList("ApiKeyAuth"))
	            .components(new Components()
	                    .addSecuritySchemes("ApiKeyAuth",
	                        new SecurityScheme()
	                            .name("X-API-KEY")
	                            .type(SecurityScheme.Type.APIKEY)
	                            .in(SecurityScheme.In.HEADER)));
	}
}
