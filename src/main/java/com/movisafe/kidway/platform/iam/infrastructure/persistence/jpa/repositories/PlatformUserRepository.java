package com.movisafe.kidway.platform.iam.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.iam.domain.model.aggregates.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlatformUserRepository extends JpaRepository<PlatformUser, Long> {
    Optional<PlatformUser> findByUsername(String username);
    Optional<PlatformUser> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
