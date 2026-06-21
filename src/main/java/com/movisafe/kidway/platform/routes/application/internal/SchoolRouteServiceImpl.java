package com.movisafe.kidway.platform.routes.application.internal;

import com.movisafe.kidway.platform.routes.domain.model.aggregates.SchoolRoute;
import com.movisafe.kidway.platform.routes.domain.services.SchoolRouteCommandService;
import com.movisafe.kidway.platform.routes.domain.services.SchoolRouteQueryService;
import com.movisafe.kidway.platform.routes.infrastructure.persistence.jpa.repositories.SchoolRouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SchoolRouteServiceImpl implements SchoolRouteCommandService, SchoolRouteQueryService {
    private final SchoolRouteRepository repository;
    public SchoolRouteServiceImpl(SchoolRouteRepository repository) { this.repository = repository; }

    @Override
    public List<SchoolRoute> findAll() { return repository.findAll(); }

    @Override
    public SchoolRoute findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("SchoolRoute not found with id " + id)); }

    @Override
    public SchoolRoute create(SchoolRoute resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public SchoolRoute update(Long id, SchoolRoute resource) {
        var existing = findById(id);
    existing.setName(resource.getName());
    existing.setOriginDistrict(resource.getOriginDistrict());
    existing.setDestinationSchool(resource.getDestinationSchool());
    existing.setSchedule(resource.getSchedule());
    existing.setStatus(resource.getStatus());
    existing.setEstimatedMinutes(resource.getEstimatedMinutes());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
