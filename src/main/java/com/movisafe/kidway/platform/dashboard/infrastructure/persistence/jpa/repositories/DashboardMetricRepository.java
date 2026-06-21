package com.movisafe.kidway.platform.dashboard.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.dashboard.domain.model.aggregates.DashboardMetric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardMetricRepository extends JpaRepository<DashboardMetric, Long> { }
