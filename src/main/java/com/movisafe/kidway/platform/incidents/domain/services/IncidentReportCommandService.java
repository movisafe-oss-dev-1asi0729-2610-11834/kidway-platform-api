package com.movisafe.kidway.platform.incidents.domain.services;

import com.movisafe.kidway.platform.incidents.domain.model.aggregates.IncidentReport;

public interface IncidentReportCommandService {
    IncidentReport create(IncidentReport resource);
    IncidentReport update(Long id, IncidentReport resource);
    void delete(Long id);
}
