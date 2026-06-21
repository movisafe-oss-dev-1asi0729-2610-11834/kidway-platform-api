package com.movisafe.kidway.platform.incidents.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.incidents.domain.model.aggregates.IncidentReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentReportRepository extends JpaRepository<IncidentReport, Long> { }
