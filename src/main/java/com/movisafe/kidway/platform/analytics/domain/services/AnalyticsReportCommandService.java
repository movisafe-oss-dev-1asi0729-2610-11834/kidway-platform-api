package com.movisafe.kidway.platform.analytics.domain.services;

import com.movisafe.kidway.platform.analytics.domain.model.aggregates.AnalyticsReport;

public interface AnalyticsReportCommandService {
    AnalyticsReport create(AnalyticsReport resource);
    AnalyticsReport update(Long id, AnalyticsReport resource);
    void delete(Long id);
}
