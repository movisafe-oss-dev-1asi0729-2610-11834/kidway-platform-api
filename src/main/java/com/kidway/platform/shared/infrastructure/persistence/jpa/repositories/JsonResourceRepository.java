package com.kidway.platform.shared.infrastructure.persistence.jpa.repositories;

import com.kidway.platform.shared.domain.model.entities.JsonResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JsonResourceRepository extends JpaRepository<JsonResource, Long> {
    List<JsonResource> findByCollectionNameOrderByInternalIdAsc(String collectionName);
    Optional<JsonResource> findByCollectionNameAndResourceId(String collectionName, String resourceId);
    boolean existsByCollectionName(String collectionName);
    boolean existsByCollectionNameAndResourceId(String collectionName, String resourceId);
    void deleteByCollectionNameAndResourceId(String collectionName, String resourceId);
}
