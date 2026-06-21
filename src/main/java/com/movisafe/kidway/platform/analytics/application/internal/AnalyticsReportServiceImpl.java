package com.movisafe.kidway.platform.analytics.application.internal;

import com.movisafe.kidway.platform.analytics.domain.model.aggregates.AnalyticsReport;
import com.movisafe.kidway.platform.analytics.domain.services.AnalyticsReportCommandService;
import com.movisafe.kidway.platform.analytics.domain.services.AnalyticsReportQueryService;
import com.movisafe.kidway.platform.analytics.infrastructure.persistence.jpa.repositories.AnalyticsReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnalyticsReportServiceImpl implements AnalyticsReportCommandService, AnalyticsReportQueryService {
    private final AnalyticsReportRepository repository;
    public AnalyticsReportServiceImpl(AnalyticsReportRepository repository) { this.repository = repository; }

    @Override
    public List<AnalyticsReport> findAll() { return repository.findAll(); }

    @Override
    public AnalyticsReport findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("AnalyticsReport not found with id " + id)); }

    @Override
    public AnalyticsReport create(AnalyticsReport resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public AnalyticsReport update(Long id, AnalyticsReport resource) {
        var existing = findById(id);
    existing.setReportName(resource.getReportName());
    existing.setPeriod(resource.getPeriod());
    existing.setAttendanceRate(resource.getAttendanceRate());
    existing.setRouteCoverage(resource.getRouteCoverage());
    existing.setIncidentCount(resource.getIncidentCount());
    existing.setFormat(resource.getFormat());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
