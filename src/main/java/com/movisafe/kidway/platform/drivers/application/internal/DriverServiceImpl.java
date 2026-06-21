package com.movisafe.kidway.platform.drivers.application.internal;

import com.movisafe.kidway.platform.drivers.domain.model.aggregates.Driver;
import com.movisafe.kidway.platform.drivers.domain.services.DriverCommandService;
import com.movisafe.kidway.platform.drivers.domain.services.DriverQueryService;
import com.movisafe.kidway.platform.drivers.infrastructure.persistence.jpa.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DriverServiceImpl implements DriverCommandService, DriverQueryService {
    private final DriverRepository repository;
    public DriverServiceImpl(DriverRepository repository) { this.repository = repository; }

    @Override
    public List<Driver> findAll() { return repository.findAll(); }

    @Override
    public Driver findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Driver not found with id " + id)); }

    @Override
    public Driver create(Driver resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public Driver update(Long id, Driver resource) {
        var existing = findById(id);
    existing.setFullName(resource.getFullName());
    existing.setLicenseNumber(resource.getLicenseNumber());
    existing.setPhone(resource.getPhone());
    existing.setStatus(resource.getStatus());
    existing.setAssignedVehicle(resource.getAssignedVehicle());
    existing.setRating(resource.getRating());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
