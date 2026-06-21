package com.movisafe.kidway.platform.dashboard.domain.services;

import com.movisafe.kidway.platform.dashboard.domain.model.aggregates.DashboardMetric;

public interface DashboardMetricCommandService {
    DashboardMetric create(DashboardMetric resource);
    DashboardMetric update(Long id, DashboardMetric resource);
    void delete(Long id);
}
