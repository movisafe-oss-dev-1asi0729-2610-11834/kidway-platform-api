package com.movisafe.kidway.platform.incidents.application.internal;

import com.movisafe.kidway.platform.incidents.domain.model.aggregates.IncidentReport;
import com.movisafe.kidway.platform.incidents.domain.services.IncidentReportCommandService;
import com.movisafe.kidway.platform.incidents.domain.services.IncidentReportQueryService;
import com.movisafe.kidway.platform.incidents.infrastructure.persistence.jpa.repositories.IncidentReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IncidentReportServiceImpl implements IncidentReportCommandService, IncidentReportQueryService {
    private final IncidentReportRepository repository;
    public IncidentReportServiceImpl(IncidentReportRepository repository) { this.repository = repository; }

    @Override
    public List<IncidentReport> findAll() { return repository.findAll(); }

    @Override
    public IncidentReport findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("IncidentReport not found with id " + id)); }

    @Override
    public IncidentReport create(IncidentReport resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public IncidentReport update(Long id, IncidentReport resource) {
        var existing = findById(id);
    existing.setTitle(resource.getTitle());
    existing.setDescription(resource.getDescription());
    existing.setRouteName(resource.getRouteName());
    existing.setReportedBy(resource.getReportedBy());
    existing.setSeverity(resource.getSeverity());
    existing.setStatus(resource.getStatus());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
