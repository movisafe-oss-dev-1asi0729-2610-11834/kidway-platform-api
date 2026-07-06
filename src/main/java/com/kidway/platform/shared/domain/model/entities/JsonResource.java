package com.kidway.platform.shared.domain.model.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "json_resources",
        uniqueConstraints = @UniqueConstraint(columnNames = {"collection_name", "resource_id"}),
        indexes = {
                @Index(name = "idx_json_resources_collection", columnList = "collection_name"),
                @Index(name = "idx_json_resources_resource", columnList = "resource_id")
        }
)
public class JsonResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalId;

    @Column(name = "collection_name", nullable = false, length = 120)
    private String collectionName;

    @Column(name = "resource_id", nullable = false, length = 120)
    private String resourceId;

    @Column(name = "container_type", nullable = false, length = 20)
    private String containerType;

    @Column(name = "payload", nullable = false, columnDefinition = "TEXT")
    private String payload;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public JsonResource() {
    }

    public JsonResource(String collectionName, String resourceId, String containerType, String payload) {
        this.collectionName = collectionName;
        this.resourceId = resourceId;
        this.containerType = containerType;
        this.payload = payload;
    }

    @PrePersist
    protected void onCreate() {
        var now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Long getInternalId() {
        return internalId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
