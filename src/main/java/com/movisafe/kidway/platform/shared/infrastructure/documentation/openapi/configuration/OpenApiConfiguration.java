package com.movisafe.kidway.platform.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI kidWayOpenApi(
            @Value("${documentation.application.description}") String description,
            @Value("${documentation.application.version}") String version) {
        return new OpenAPI()
                .info(new Info()
                        .title("KidWay Platform API")
                        .description(description)
                        .version(version)
                        .contact(new Contact().name("MoviSafe Startup").email("contact@kidway.pe"))
                        .license(new License().name("MIT License")));
    }
}
