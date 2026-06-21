package com.movisafe.kidway.platform.userprofiles.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.userprofiles.domain.model.aggregates.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> { }
