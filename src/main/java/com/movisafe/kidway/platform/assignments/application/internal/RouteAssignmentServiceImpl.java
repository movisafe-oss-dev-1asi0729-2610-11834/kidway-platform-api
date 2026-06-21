package com.movisafe.kidway.platform.assignments.application.internal;

import com.movisafe.kidway.platform.assignments.domain.model.aggregates.RouteAssignment;
import com.movisafe.kidway.platform.assignments.domain.services.RouteAssignmentCommandService;
import com.movisafe.kidway.platform.assignments.domain.services.RouteAssignmentQueryService;
import com.movisafe.kidway.platform.assignments.infrastructure.persistence.jpa.repositories.RouteAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RouteAssignmentServiceImpl implements RouteAssignmentCommandService, RouteAssignmentQueryService {
    private final RouteAssignmentRepository repository;
    public RouteAssignmentServiceImpl(RouteAssignmentRepository repository) { this.repository = repository; }

    @Override
    public List<RouteAssignment> findAll() { return repository.findAll(); }

    @Override
    public RouteAssignment findById(Long id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("RouteAssignment not found with id " + id)); }

    @Override
    public RouteAssignment create(RouteAssignment resource) {
        resource.setId(null);
        return repository.save(resource);
    }

    @Override
    public RouteAssignment update(Long id, RouteAssignment resource) {
        var existing = findById(id);
    existing.setRouteName(resource.getRouteName());
    existing.setDriverName(resource.getDriverName());
    existing.setVehiclePlate(resource.getVehiclePlate());
    existing.setStudentName(resource.getStudentName());
    existing.setPickupStop(resource.getPickupStop());
    existing.setStatus(resource.getStatus());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
