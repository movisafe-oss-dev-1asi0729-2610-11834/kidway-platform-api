package com.kidway.platform.shared.infrastructure.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI kidWayOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("KidWay Platform API")
                        .description("Gateway backend for the KidWay school transport frontend. It exposes IAM demo endpoints and CRUD access to frontend data collections seeded from db.json.")
                        .version("1.0.0")
                        .contact(new Contact().name("KidWay Development Team"))
                        .license(new License().name("MIT")));
    }
}
