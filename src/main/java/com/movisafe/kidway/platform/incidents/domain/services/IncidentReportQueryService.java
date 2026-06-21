package com.movisafe.kidway.platform.incidents.domain.services;

import com.movisafe.kidway.platform.incidents.domain.model.aggregates.IncidentReport;
import java.util.List;

public interface IncidentReportQueryService {
    List<IncidentReport> findAll();
    IncidentReport findById(Long id);
}
