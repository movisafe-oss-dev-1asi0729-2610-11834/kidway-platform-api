package com.movisafe.kidway.platform.analytics.domain.services;

import com.movisafe.kidway.platform.analytics.domain.model.aggregates.AnalyticsReport;
import java.util.List;

public interface AnalyticsReportQueryService {
    List<AnalyticsReport> findAll();
    AnalyticsReport findById(Long id);
}
