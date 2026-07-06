package com.kidway.platform.shared.infrastructure.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Converts Render/Heroku style DATABASE_URL values into Spring datasource properties.
 *
 * Render exposes Postgres URLs as:
 * postgresql://USER:PASSWORD@HOST:PORT/DATABASE
 *
 * Spring Boot expects:
 * jdbc:postgresql://HOST:PORT/DATABASE
 */
public class RenderDatabaseUrlEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        var databaseUrl = environment.getProperty("DATABASE_URL");
        if (databaseUrl == null || databaseUrl.isBlank()) {
            return;
        }
        if (!databaseUrl.startsWith("postgres://") && !databaseUrl.startsWith("postgresql://")) {
            return;
        }
        var explicitSpringDatasourceUrl = environment.getProperty("SPRING_DATASOURCE_URL");
        if (explicitSpringDatasourceUrl != null && !explicitSpringDatasourceUrl.isBlank()) {
            return;
        }
        try {
            URI uri = URI.create(databaseUrl);
            String rawUserInfo = uri.getRawUserInfo();
            String username = null;
            String password = null;
            if (rawUserInfo != null) {
                String[] parts = rawUserInfo.split(":", 2);
                username = urlDecode(parts[0]);
                if (parts.length > 1) {
                    password = urlDecode(parts[1]);
                }
            }
            String path = uri.getRawPath() == null ? "" : uri.getRawPath();
            String query = uri.getRawQuery();
            String jdbcUrl = "jdbc:postgresql://" + uri.getHost() + ":" + effectivePort(uri) + path;
            if (query != null && !query.isBlank()) {
                jdbcUrl += "?" + query;
            } else {
                jdbcUrl += "?sslmode=require";
            }

            Map<String, Object> properties = new HashMap<>();
            properties.put("spring.datasource.url", jdbcUrl);
            if (username != null) properties.put("spring.datasource.username", username);
            if (password != null) properties.put("spring.datasource.password", password);
            properties.put("spring.datasource.driver-class-name", "org.postgresql.Driver");
            environment.getPropertySources().addFirst(new MapPropertySource("renderDatabaseUrl", properties));
        } catch (RuntimeException ignored) {
            // Let Spring Boot fail normally if no valid datasource properties are provided.
        }
    }

    private int effectivePort(URI uri) {
        return uri.getPort() > 0 ? uri.getPort() : 5432;
    }

    private String urlDecode(String value) {
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
    }
}
