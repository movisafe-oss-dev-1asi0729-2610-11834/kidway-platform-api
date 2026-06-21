package com.movisafe.kidway.platform.trips.application.internal;

import com.movisafe.kidway.platform.trips.domain.model.aggregates.Trip;
import com.movisafe.kidway.platform.trips.domain.services.TripCommandService;
import com.movisafe.kidway.platform.trips.domain.services.TripQueryService;
import com.movisafe.kidway.platform.trips.infrastructure.persistence.jpa.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TripServiceImpl implements TripCommandService, TripQueryService {
    private final TripRepository repository;
    public TripServiceImpl(TripRepository repository) { this.repository = repository; }

    @Override
    public List<Trip> findAll() { return repository.findAll(); }

    @Override
    public Trip findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Trip not found with id " + id)); }

    @Override
    public Trip create(Trip resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public Trip update(Long id, Trip resource) {
        var existing = findById(id);
    existing.setRouteName(resource.getRouteName());
    existing.setDriverName(resource.getDriverName());
    existing.setVehiclePlate(resource.getVehiclePlate());
    existing.setStartedAt(resource.getStartedAt());
    existing.setEndedAt(resource.getEndedAt());
    existing.setStatus(resource.getStatus());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
