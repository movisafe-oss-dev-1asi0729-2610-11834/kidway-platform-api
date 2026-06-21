package com.movisafe.kidway.platform.drivers.infrastructure.persistence.jpa.repositories;

import com.movisafe.kidway.platform.drivers.domain.model.aggregates.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> { }
