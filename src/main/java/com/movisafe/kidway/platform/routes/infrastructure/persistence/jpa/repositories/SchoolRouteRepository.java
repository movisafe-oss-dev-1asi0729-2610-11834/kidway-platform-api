package com.movisafe.kidway.platform.routes.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.routes.domain.model.aggregates.SchoolRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRouteRepository extends JpaRepository<SchoolRoute, Long> { }
