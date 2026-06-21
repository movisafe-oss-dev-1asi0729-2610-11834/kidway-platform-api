package com.movisafe.kidway.platform.dashboard.domain.services;

import com.movisafe.kidway.platform.dashboard.domain.model.aggregates.DashboardMetric;
import java.util.List;

public interface DashboardMetricQueryService {
    List<DashboardMetric> findAll();
    DashboardMetric findById(Long id);
}
