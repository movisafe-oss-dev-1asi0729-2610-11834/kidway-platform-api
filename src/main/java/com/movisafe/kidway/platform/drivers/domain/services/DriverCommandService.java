package com.movisafe.kidway.platform.drivers.domain.services;

import com.movisafe.kidway.platform.drivers.domain.model.aggregates.Driver;

public interface DriverCommandService {
    Driver create(Driver resource);
    Driver update(Long id, Driver resource);
    void delete(Long id);
}
