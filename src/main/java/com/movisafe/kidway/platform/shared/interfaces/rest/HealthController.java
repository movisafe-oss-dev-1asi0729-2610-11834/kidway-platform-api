package com.movisafe.kidway.platform.shared.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping({"/api/v1/health", "/api/health"})
@Tag(name = "Health Check", description = "API health and deployment status endpoints")
public class HealthController {
    @GetMapping
    public Map<String, Object> health() {
        return Map.of(
                "status", "UP",
                "service", "KidWay Platform API",
                "timestamp", LocalDateTime.now().toString()
        );
    }
}
