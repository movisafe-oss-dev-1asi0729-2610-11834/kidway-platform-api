package com.movisafe.kidway.platform.fleet.domain.services;

import com.movisafe.kidway.platform.fleet.domain.model.aggregates.Vehicle;
import java.util.List;

public interface VehicleQueryService {
    List<Vehicle> findAll();
    Vehicle findById(Long id);
}
