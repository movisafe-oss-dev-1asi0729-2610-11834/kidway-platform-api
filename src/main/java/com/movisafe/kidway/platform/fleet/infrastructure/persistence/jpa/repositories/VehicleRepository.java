package com.movisafe.kidway.platform.fleet.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.fleet.domain.model.aggregates.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> { }
