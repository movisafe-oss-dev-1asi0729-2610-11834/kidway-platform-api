package com.movisafe.kidway.platform.drivers.domain.services;

import com.movisafe.kidway.platform.drivers.domain.model.aggregates.Driver;
import java.util.List;

public interface DriverQueryService {
    List<Driver> findAll();
    Driver findById(Long id);
}
