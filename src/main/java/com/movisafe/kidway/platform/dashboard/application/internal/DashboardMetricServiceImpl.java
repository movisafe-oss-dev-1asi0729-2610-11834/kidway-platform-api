package com.movisafe.kidway.platform.dashboard.application.internal;

import com.movisafe.kidway.platform.dashboard.domain.model.aggregates.DashboardMetric;
import com.movisafe.kidway.platform.dashboard.domain.services.DashboardMetricCommandService;
import com.movisafe.kidway.platform.dashboard.domain.services.DashboardMetricQueryService;
import com.movisafe.kidway.platform.dashboard.infrastructure.persistence.jpa.repositories.DashboardMetricRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DashboardMetricServiceImpl implements DashboardMetricCommandService, DashboardMetricQueryService {
    private final DashboardMetricRepository repository;
    public DashboardMetricServiceImpl(DashboardMetricRepository repository) { this.repository = repository; }

    @Override
    public List<DashboardMetric> findAll() { return repository.findAll(); }

    @Override
    public DashboardMetric findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("DashboardMetric not found with id " + id)); }

    @Override
    public DashboardMetric create(DashboardMetric resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public DashboardMetric update(Long id, DashboardMetric resource) {
        var existing = findById(id);
    existing.setMetricKey(resource.getMetricKey());
    existing.setMetricLabel(resource.getMetricLabel());
    existing.setMetricValue(resource.getMetricValue());
    existing.setUnit(resource.getUnit());
    existing.setScope(resource.getScope());
    existing.setTrend(resource.getTrend());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
