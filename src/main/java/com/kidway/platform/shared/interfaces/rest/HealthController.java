package com.kidway.platform.shared.interfaces.rest;

import com.kidway.platform.shared.interfaces.rest.resources.ApiMessageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Platform Health", description = "Basic API health endpoint.")
public class HealthController {
    @GetMapping({"/api/v1/health", "/api/health"})
    @Operation(summary = "Health check")
    public ApiMessageResource health() {
        return ApiMessageResource.of("KidWay Platform API is running.");
    }
}
