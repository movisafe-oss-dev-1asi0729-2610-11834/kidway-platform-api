package com.movisafe.kidway.platform.analytics.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.analytics.domain.model.aggregates.AnalyticsReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyticsReportRepository extends JpaRepository<AnalyticsReport, Long> { }
