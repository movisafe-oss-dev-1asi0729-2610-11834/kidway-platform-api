package com.movisafe.kidway.platform.fleet.domain.services;

import com.movisafe.kidway.platform.fleet.domain.model.aggregates.Vehicle;

public interface VehicleCommandService {
    Vehicle create(Vehicle resource);
    Vehicle update(Long id, Vehicle resource);
    void delete(Long id);
}
