package com.movisafe.kidway.platform.tracking.application.internal;

import com.movisafe.kidway.platform.tracking.domain.model.aggregates.TrackingEvent;
import com.movisafe.kidway.platform.tracking.domain.services.TrackingEventCommandService;
import com.movisafe.kidway.platform.tracking.domain.services.TrackingEventQueryService;
import com.movisafe.kidway.platform.tracking.infrastructure.persistence.jpa.repositories.TrackingEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TrackingEventServiceImpl implements TrackingEventCommandService, TrackingEventQueryService {
    private final TrackingEventRepository repository;
    public TrackingEventServiceImpl(TrackingEventRepository repository) { this.repository = repository; }

    @Override
    public List<TrackingEvent> findAll() { return repository.findAll(); }

    @Override
    public TrackingEvent findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("TrackingEvent not found with id " + id)); }

    @Override
    public TrackingEvent create(TrackingEvent resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public TrackingEvent update(Long id, TrackingEvent resource) {
        var existing = findById(id);
    existing.setVehiclePlate(resource.getVehiclePlate());
    existing.setLatitude(resource.getLatitude());
    existing.setLongitude(resource.getLongitude());
    existing.setSpeed(resource.getSpeed());
    existing.setEventTime(resource.getEventTime());
    existing.setStatus(resource.getStatus());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
