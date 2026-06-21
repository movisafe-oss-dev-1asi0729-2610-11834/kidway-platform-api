package com.movisafe.kidway.platform.tracking.domain.services;

import com.movisafe.kidway.platform.tracking.domain.model.aggregates.TrackingEvent;

public interface TrackingEventCommandService {
    TrackingEvent create(TrackingEvent resource);
    TrackingEvent update(Long id, TrackingEvent resource);
    void delete(Long id);
}
