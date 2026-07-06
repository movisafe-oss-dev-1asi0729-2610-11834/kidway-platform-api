package com.kidway.platform.shared.application.internal.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kidway.platform.shared.domain.model.entities.JsonResource;
import com.kidway.platform.shared.infrastructure.persistence.jpa.repositories.JsonResourceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class JsonResourceService {
    private static final String ARRAY = "ARRAY";
    private static final String OBJECT = "OBJECT";
    private static final String SINGLETON = "singleton";

    private final JsonResourceRepository repository;
    private final ObjectMapper objectMapper;

    public JsonResourceService(JsonResourceRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public List<String> listCollections() {
        return repository.findAll().stream()
                .map(JsonResource::getCollectionName)
                .distinct()
                .sorted()
                .toList();
    }

    @Transactional(readOnly = true)
    public JsonNode getCollection(String collectionName, Map<String, String> filters) {
        var records = repository.findByCollectionNameOrderByInternalIdAsc(collectionName);
        if (records.isEmpty()) {
            throw new EntityNotFoundException("Collection not found: " + collectionName);
        }
        var first = records.getFirst();
        if (OBJECT.equals(first.getContainerType()) && SINGLETON.equals(first.getResourceId())) {
            return readPayload(first);
        }
        ArrayNode array = objectMapper.createArrayNode();
        records.stream()
                .map(this::readPayload)
                .filter(node -> matchesFilters(node, filters))
                .forEach(array::add);
        return array;
    }

    @Transactional(readOnly = true)
    public JsonNode getResource(String collectionName, String resourceId) {
        return repository.findByCollectionNameAndResourceId(collectionName, resourceId)
                .map(this::readPayload)
                .orElseThrow(() -> new EntityNotFoundException("Resource not found: " + collectionName + "/" + resourceId));
    }

    @Transactional
    public JsonNode createResource(String collectionName, JsonNode body) {
        ObjectNode payload = ensureObject(body);
        String resourceId = extractOrGenerateId(payload);
        if (repository.existsByCollectionNameAndResourceId(collectionName, resourceId)) {
            throw new IllegalArgumentException("Resource already exists: " + collectionName + "/" + resourceId);
        }
        if (!payload.has("id")) {
            payload.put("id", resourceId);
        }
        var entity = new JsonResource(collectionName, resourceId, ARRAY, writePayload(payload));
        repository.save(entity);
        return payload;
    }

    @Transactional
    public JsonNode replaceResource(String collectionName, String resourceId, JsonNode body) {
        ObjectNode payload = ensureObject(body);
        payload.put("id", resourceId);
        var entity = repository.findByCollectionNameAndResourceId(collectionName, resourceId)
                .orElseGet(() -> new JsonResource(collectionName, resourceId, ARRAY, "{}"));
        entity.setPayload(writePayload(payload));
        entity.setContainerType(ARRAY);
        repository.save(entity);
        return payload;
    }

    @Transactional
    public JsonNode patchResource(String collectionName, String resourceId, JsonNode body) {
        ObjectNode patch = ensureObject(body);
        var entity = repository.findByCollectionNameAndResourceId(collectionName, resourceId)
                .orElseThrow(() -> new EntityNotFoundException("Resource not found: " + collectionName + "/" + resourceId));
        ObjectNode current = ensureObject(readPayload(entity));
        patch.fields().forEachRemaining(entry -> current.set(entry.getKey(), entry.getValue()));
        entity.setPayload(writePayload(current));
        repository.save(entity);
        return current;
    }

    @Transactional
    public void deleteResource(String collectionName, String resourceId) {
        if (!repository.existsByCollectionNameAndResourceId(collectionName, resourceId)) {
            throw new EntityNotFoundException("Resource not found: " + collectionName + "/" + resourceId);
        }
        repository.deleteByCollectionNameAndResourceId(collectionName, resourceId);
    }

    @Transactional
    public void upsertCollectionFromJson(String collectionName, JsonNode node) {
        if (node.isArray()) {
            int index = 1;
            for (JsonNode item : node) {
                ObjectNode itemObject = ensureObject(item);
                String id = extractId(itemObject).orElse(String.valueOf(index));
                if (!itemObject.has("id")) {
                    itemObject.put("id", id);
                }
                var entity = repository.findByCollectionNameAndResourceId(collectionName, id)
                        .orElseGet(() -> new JsonResource(collectionName, id, ARRAY, "{}"));
                entity.setContainerType(ARRAY);
                entity.setPayload(writePayload(itemObject));
                repository.save(entity);
                index++;
            }
            return;
        }
        var entity = repository.findByCollectionNameAndResourceId(collectionName, SINGLETON)
                .orElseGet(() -> new JsonResource(collectionName, SINGLETON, OBJECT, "{}"));
        entity.setContainerType(OBJECT);
        entity.setPayload(writePayload(node));
        repository.save(entity);
    }

    @Transactional(readOnly = true)
    public Optional<JsonNode> findArrayItemByField(String collectionName, String fieldName, String value) {
        return repository.findByCollectionNameOrderByInternalIdAsc(collectionName).stream()
                .map(this::readPayload)
                .filter(JsonNode::isObject)
                .filter(node -> node.has(fieldName) && value.equalsIgnoreCase(node.get(fieldName).asText()))
                .findFirst();
    }

    @Transactional(readOnly = true)
    public List<JsonNode> findAllArrayItems(String collectionName) {
        return repository.findByCollectionNameOrderByInternalIdAsc(collectionName).stream()
                .map(this::readPayload)
                .toList();
    }

    private JsonNode readPayload(JsonResource resource) {
        try {
            return objectMapper.readTree(resource.getPayload());
        } catch (Exception exception) {
            throw new IllegalStateException("Invalid JSON payload in resource " + resource.getCollectionName() + "/" + resource.getResourceId(), exception);
        }
    }

    private String writePayload(JsonNode node) {
        try {
            return objectMapper.writeValueAsString(node);
        } catch (Exception exception) {
            throw new IllegalArgumentException("Invalid JSON payload", exception);
        }
    }

    private ObjectNode ensureObject(JsonNode node) {
        if (node == null || !node.isObject()) {
            throw new IllegalArgumentException("The request body must be a JSON object.");
        }
        return (ObjectNode) node.deepCopy();
    }

    private Optional<String> extractId(ObjectNode node) {
        if (!node.hasNonNull("id")) {
            return Optional.empty();
        }
        return Optional.of(node.get("id").asText());
    }

    private String extractOrGenerateId(ObjectNode node) {
        return extractId(node).orElse(UUID.randomUUID().toString());
    }

    private boolean matchesFilters(JsonNode node, Map<String, String> filters) {
        if (filters == null || filters.isEmpty()) return true;
        for (var entry : filters.entrySet()) {
            var key = entry.getKey();
            var expected = entry.getValue();
            if (expected == null || expected.isBlank()) continue;
            if (!node.has(key)) return false;
            if (!node.get(key).asText().equalsIgnoreCase(expected)) return false;
        }
        return true;
    }
}
