package com.movisafe.kidway.platform.trips.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.trips.domain.model.aggregates.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> { }
