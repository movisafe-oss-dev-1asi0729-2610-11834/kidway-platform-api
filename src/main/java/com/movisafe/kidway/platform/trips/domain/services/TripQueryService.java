package com.movisafe.kidway.platform.trips.domain.services;

import com.movisafe.kidway.platform.trips.domain.model.aggregates.Trip;
import java.util.List;

public interface TripQueryService {
    List<Trip> findAll();
    Trip findById(Long id);
}
