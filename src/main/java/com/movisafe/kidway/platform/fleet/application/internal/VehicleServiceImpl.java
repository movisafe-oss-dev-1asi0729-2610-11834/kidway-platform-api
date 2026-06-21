package com.movisafe.kidway.platform.fleet.application.internal;

import com.movisafe.kidway.platform.fleet.domain.model.aggregates.Vehicle;
import com.movisafe.kidway.platform.fleet.domain.services.VehicleCommandService;
import com.movisafe.kidway.platform.fleet.domain.services.VehicleQueryService;
import com.movisafe.kidway.platform.fleet.infrastructure.persistence.jpa.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleServiceImpl implements VehicleCommandService, VehicleQueryService {
    private final VehicleRepository repository;
    public VehicleServiceImpl(VehicleRepository repository) { this.repository = repository; }

    @Override
    public List<Vehicle> findAll() { return repository.findAll(); }

    @Override
    public Vehicle findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Vehicle not found with id " + id)); }

    @Override
    public Vehicle create(Vehicle resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public Vehicle update(Long id, Vehicle resource) {
        var existing = findById(id);
    existing.setPlate(resource.getPlate());
    existing.setModel(resource.getModel());
    existing.setCapacity(resource.getCapacity());
    existing.setStatus(resource.getStatus());
    existing.setCompanyName(resource.getCompanyName());
    existing.setCurrentRoute(resource.getCurrentRoute());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
