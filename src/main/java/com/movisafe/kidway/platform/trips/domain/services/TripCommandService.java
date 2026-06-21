package com.movisafe.kidway.platform.trips.domain.services;

import com.movisafe.kidway.platform.trips.domain.model.aggregates.Trip;

public interface TripCommandService {
    Trip create(Trip resource);
    Trip update(Long id, Trip resource);
    void delete(Long id);
}
