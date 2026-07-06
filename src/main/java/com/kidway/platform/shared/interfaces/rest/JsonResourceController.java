package com.kidway.platform.shared.interfaces.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.kidway.platform.shared.application.internal.services.JsonResourceService;
import com.kidway.platform.shared.interfaces.rest.resources.ApiMessageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Data Resource Gateway", description = "Generic CRUD API for KidWay frontend collections seeded from db.json.")
public class JsonResourceController {
    private final JsonResourceService jsonResourceService;

    public JsonResourceController(JsonResourceService jsonResourceService) {
        this.jsonResourceService = jsonResourceService;
    }

    @GetMapping({"/api/v1/collections", "/api/collections"})
    @Operation(summary = "List available collections", description = "Returns all seeded collection names from the KidWay frontend db.json.")
    public List<String> listCollections() {
        return jsonResourceService.listCollections();
    }

    @GetMapping({"/api/v1/{collectionName}", "/api/{collectionName}"})
    @Operation(summary = "Get a collection", description = "Returns an array or singleton object. Supports simple exact-match filters, e.g. /api/v1/dashboardViews?role=company.")
    public JsonNode getCollection(@PathVariable String collectionName, @RequestParam Map<String, String> filters) {
        return jsonResourceService.getCollection(collectionName, filters);
    }

    @GetMapping({"/api/v1/{collectionName}/{resourceId}", "/api/{collectionName}/{resourceId}"})
    @Operation(summary = "Get a resource by id", description = "Returns one item from an array-backed collection.")
    public JsonNode getResource(@PathVariable String collectionName, @PathVariable String resourceId) {
        return jsonResourceService.getResource(collectionName, resourceId);
    }

    @PostMapping({"/api/v1/{collectionName}", "/api/{collectionName}"})
    @Operation(summary = "Create a resource", description = "Adds a JSON object to an array-backed collection. If id is missing, the backend generates one.")
    public ResponseEntity<JsonNode> createResource(@PathVariable String collectionName, @RequestBody JsonNode body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jsonResourceService.createResource(collectionName, body));
    }

    @PutMapping({"/api/v1/{collectionName}/{resourceId}", "/api/{collectionName}/{resourceId}"})
    @Operation(summary = "Replace a resource", description = "Replaces or creates an item in an array-backed collection.")
    public JsonNode replaceResource(@PathVariable String collectionName, @PathVariable String resourceId, @RequestBody JsonNode body) {
        return jsonResourceService.replaceResource(collectionName, resourceId, body);
    }

    @PatchMapping({"/api/v1/{collectionName}/{resourceId}", "/api/{collectionName}/{resourceId}"})
    @Operation(summary = "Patch a resource", description = "Applies a shallow JSON patch to an existing resource.")
    public JsonNode patchResource(@PathVariable String collectionName, @PathVariable String resourceId, @RequestBody JsonNode body) {
        return jsonResourceService.patchResource(collectionName, resourceId, body);
    }

    @DeleteMapping({"/api/v1/{collectionName}/{resourceId}", "/api/{collectionName}/{resourceId}"})
    @Operation(summary = "Delete a resource", description = "Deletes one item from a collection.")
    public ApiMessageResource deleteResource(@PathVariable String collectionName, @PathVariable String resourceId) {
        jsonResourceService.deleteResource(collectionName, resourceId);
        return ApiMessageResource.of("Resource deleted: " + collectionName + "/" + resourceId);
    }
}
